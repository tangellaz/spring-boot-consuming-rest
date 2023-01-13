package restproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@SpringBootApplication
public class AssessmentApplication {

	private static final Logger log = LoggerFactory.getLogger(AssessmentApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(AssessmentApplication.class, args);
		ctx.close();
	}

	public ParameterizedTypeReference<Map<Integer, EHR2014DTO>> responseType =
			new ParameterizedTypeReference<Map<Integer, EHR2014DTO>>() {};
	public String API_URL = "https://www.healthit.gov/data/open-api?source=Meaningful-Use-Acceleration-Scorecard.csv&period=2014";
	public RequestEntity<Void> request = RequestEntity.get(API_URL)
			.accept(MediaType.APPLICATION_JSON).build();

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {

			/* Get data and bind. Unable to use getForObject since data received is map with integer keys.*/
			Map<Integer, EHR2014DTO> dataMap = restTemplate.exchange(request, responseType).getBody();

			/* Data cleanup: removing integer key from received data. */
			assert dataMap != null;
			EHR2014DTO[] dataValues = dataMap.values().toArray(new EHR2014DTO[0]);

			/* Filter out non-states, optional descending sort on value only not alphabetical. */
			dataValues = Arrays.stream(dataValues)
					.filter(obj -> !"District Of Columbia".equals(obj.getRegion()) && !"National".equals(obj.getRegion()))
//					.sorted((a, b) -> b.getPctMU().compareTo(a.getPctMU())) // Sort descending order
					.toArray(EHR2014DTO[]::new);

			/* Convert filtered array to map */
			CustomTreeMap customTreeMap = new CustomTreeMap();
			customTreeMap.setCustomTreeMap(dataValues);

			/* Convert map to filtered and sorted array */
			SortedData sortedData = new SortedData();
			sortedData.setSortedData(customTreeMap);

			log.info("\n\n" +
					"% eligible and critical access hospitals demonstrating Meaningful Use of CEHRT" +
					" in 2014 printed by state in descending order:" + "\n" +
					sortedData);
			log.info("\n\n" + "Alternate view of data for readability:" + "\n" +
					"\t" + "Format:" + "\t" + "{pct_hospitals_mu: [list of states]}" + "\n" +
					"Mapped Data:" + "\n" +
					customTreeMap); //Alternate viewing of sorted data
		};
	}
}
