Description
=============================
This app prints out data (the percentage of eligible and critical access hospitals that have demonstrated Meaningful Use of certified electronic health record (EHR) technology (CEHRT) in the year 2014) fetched from HealthIT.gov's open API. The data is processed and printed in the terminal by state and in descending order.

#### Developer decisions:
* States with the same percentage were sorted alphabetically as this seemed more intuitive for user readability.
* Non-states (District of Columbia, National) were filtered out to align with the requirement.
* In addition to the requirement, an alternate view of the data is presented which may improve readability and offer new insights.

#### Technologies Used:
* Spring Boot
* Maven
* Docker & Docker Hub
* IntelliJ IDEA Community Edition

Available Scripts
=============================

### Running from Docker Hub
`docker run tangellaz/assessment.jar`

### Running locally
* #### Using Maven:
`./mvnw spring-boot:run`

* #### From jar file:
`java -jar target/assessment-0.0.1.jar`

How I worked on this project
=============================
I started out by meticulously combing the requirement (assessment email). I made sure I understood what was being asked and then checked HealhIT.gov to see exactly what data the requirement was after.

I then analyzed the docs and the API data at HealhIT.gov. Reading the docs, I recognized I can filter the data to the year 2014 by appending "&period=2014" to the GET request. 

Next, I built out the <a href="https://spring.io/guides/gs/consuming-rest/">Consuming a RESTful Web Service </a> tutorial on spring.io. With this base application, I then configured this app to work with <a href="https://jsonplaceholder.typicode.com/">JSONPlaceholder</a> which is an API I was familiar with.

From there I was able to configure the app to work with the HealthIT.gov API with a little fidgeting to bind to the data which had integer keys. The rest of the project was data processing (filtering, sorting) in Java and logging to the terminal where I was forever grateful for Google and Stack Overflow.

If there was more time, I would
=============================
* Figure out the configuration with RestTemplate in the controller.
* Add tests

If you got this far,
=============================
Thank you for taking the time to read this. I learned an incredible amount and am eager to continue learning. If you have any feedback, please feel free to let me know!

Thanks! -Tyler