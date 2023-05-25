# java-data-structures

### Mettle Coding Challenge
Perfect Square Roots Solution can be found here: https://github.com/revinkama/java-data-structures/blob/main/src/main/java/com/ds/FindThePerfectSquares.java

Perfect Square Roots Tests can be found here: https://github.com/revinkama/java-data-structures/blob/main/src/test/java/com/ds/FindThePerfectSquareTests.java

### Running Perfect Squares
I created a main method in the class in order to make running it easier. Just compile and run the class!

### Mettle Questions and Answers

**Q. Have you ever worked with any Java design patterns? If yes, please describe which patterns you have used and the use cases/scenarios in which you used them.**

A. Yes I have worked with a handful of design patterns, I will be listing a couple and how I used them.
- Singleton: I used the Singleton design pattern at XSell Technologies to have one instance of the Map being used. We wanted one instance of this map to be used globally throughout the application. Having one instance of this map allows for the same data being used in other services/classes. 
- Pub/Sub: I used the Pub/Sub design pattern at XSell Technologies when integrating Kafka Messaging Queues for reporting purposes. When events coming in from the UI are published to the topic required, a listener is applied to that topic, in order to manipulate the data and write to another topic. 
- Factory: I used the Factory design pattern to create new instances of events that share common functionality and variables. Factory design pattern allows for creating events with boilerplate code already applied, just need to override methods that are commonly shared. 

**Q. Have you designed and/or developed any RESTful APIs? Please describe where and why these were used.**

A. Yes I have designed and developed many RESTful APIs. One I can think of is account creation. This api had the path /api/v1/users, and RequestMappings for different CRUD operations were created. The reason this api was used was because agents were trying to create their own accounts, make updates to their accounts, or delete their accounts. Main reason is to make updates to our database, so users reflect as needed. 


**Q. Any hands-on experience in the cloud. Please describe the services worked on.**

A. Yes I have some cloud experience. I haven’t created anything in the cloud yet, but I know my way around it. At XSell, we use AWS as our cloud provider. We use Harness to deploy to the cloud. We also use Snowflake as our cloud database. I have experience querying through the Snowflake tables, and making JPA operations on the backend, to hit our snowflake db. We use ElasticSearch in AWS for the events being created on the UI, to make sure everything is working as expected.  

**Q. Do you have experience in unit testing, integration testing of the REST APIs? Please describe it.**

A. Yes I have unit test experience. My whole 5 years of development have been TDD. Meaning were creating tests first, before we create the code needed to make it pass. I have experience with JUnit, Mockito and Cucumber testing. JUnit and Mockito were used to create unit tests within the code. We tended to use mockito to mock downstream services that weren’t supposed to be used. Cucumber was used at Discover Financial Services as a BDD automation scripts.
  

**Q. What are the advantages of using the Spring Framework in Java development? Have you worked with any Spring modules or features?**

A. There are many advantages to using the Spring Framework but a few I can think of are:
- The upfront cost of creating boilerplate/redundant code is removed. With spring initializr, developers can easily import the right modules/dependencies needed in order to build the application quicker, and cleaner. 
- Spring has many libraries for many things that developers can use/need. Libraries are imported via pom.xml file. This file gives a run down of the application and all the dependencies it needs in order for it to run. Some libraries I can think of are Spring Actuator, Spring JPA, Spring Security, Spring Web, etc… Actuator is used to health check updates for services. JPA is used to allow for queries to make database changes. Security is used to authentication/access controls. 
- Creation and use of POJO’s. POJO’s are plain old java objects that developers can create and use to their benefits. 
- Dependency Injection and Inversion of Control are the main benefits of Spring. This allows the application to build services when needed/imported; instead of taking up memory allocation for these services at compile time. These dependencies/services are considered Beans. Beans have lifecycles, that the spring framework takes care off, instead of a person doing it. 

**Q. Have you worked with any build automation tools in Java development, such as Maven or Gradle? Can you share any experiences you've had using them?**

A. Yes I have experience using Maven and Gradle. We used maven/gradle to run builds. Builds are considered successful when all tests pass. We integrated maven/gradle in our jenkins file in order for the Jenkins pipeline to run successfully, tests had to pass first. This allows for higher code quality. 
