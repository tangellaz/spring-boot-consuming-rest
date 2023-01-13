/*
* Controller unused. Unable to get configuration working with RestTemplate
*/

//package restproject;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.MediaType;
//import org.springframework.http.RequestEntity;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//public class EHR2014Controller {
//    private ParameterizedTypeReference<HashMap<Integer, EHR2014DTO>> responseType =
//            new ParameterizedTypeReference<HashMap<Integer, EHR2014DTO>>() {};
//    private RequestEntity<Void> request = RequestEntity.get("https://www.healthit.gov/data/open-api?source=Meaningful-Use-Acceleration-Scorecard.csv&period=2014")
//            .accept(MediaType.APPLICATION_JSON).build();
//
//    @Autowired
//    private RestTemplate restTemplate; //issues with RestTemplate and annotation
//
////  get data and store as map
//    public Map<Integer, EHR2014DTO> getData() {
//        return restTemplate.exchange(request, responseType).getBody();
//    }
//}
