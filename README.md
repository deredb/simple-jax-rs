# simple-jax-rs
Simple test of RESTful API using JAX-RS with Tomcat server

The tools I used
1. I am using Appache Tomcat 7.0.88 with Eclipse EE Photon version and created Maven project<br>
  *Tomcat does not provide jax-rs implementaion, but we can use Jersey API which provide the implementation<br>
      [Is Tomcat a JAX-RS aware Servlet Container?](https://stackoverflow.com/questions/30176555/is-tomcat-a-jax-rs-aware-servlet-container)<br>
      This is solved by adding the following dependency to pom.xml file
        ```
                <groupId>org.glassfish.jersey.containers</groupId>
                <artifactId>jersey-container-servlet</artifactId>
                <version>2.25.1</version>
        ```
2. Similarly, to identify the resource class (i.e Book.java) as serializable to and from JSON we need Java EE API called JAXB. 
  *Tomcat does not provide implemntation, and thus the Jackson API dependency is added to pom.xml to support MediaType.APPLICATION.JSON <br>
  ***only JAXB annotation we require is @XmlRootElement on the resouce class so that it can be serialize and deserialize as JSON<br>
  ```
  <dependency>
    <groupId>org.glassfish.jersey.media</groupId>
    <artifactId>jersey-media-json-jackson</artifactId>
    <version>2.27</version>
</dependency>
  ```
3. No web.xml file. The pom xml file includes a line to reflect that ```[<failOnMissingWebXml>false</failOnMissingWebXml>]```
4. once we run the application: Run AS > Run on Server, go to the following API end points
  ** My Tomcat runs on port 9090 because 8080 used by another applicaiton. You can go to your Tomcat folder server.xml file and switch the port. This
  can be done from Eclipse, at least that what I done<br>
  ``` <Connector connectionTimeout="20000" port="9090" protocol="HTTP/1.1" redirectPort="8443"/>```
  - my base URL http://localhost:9090/myrest/api <br>
  - For plain text output  http://localhost:9090/myrest/api/books<br>
    output: <br>
    ```
    [{"Hello":"World"}]
    ```
    <br>The above is a JsonArray converted toString <br>
    - For parameterized API call http://localhost:9090/myrest/api/books/{mytext}<br>
    <br>output: <br>
    ```
    {"price":12.3,"title":"{mytext}"}
    ```
    The above return a JSON object
    - For getting JSON array http://localhost:9090/myrest/api/books/list<br>
    output: <br>
    ```
      [ {
        "price": 12.3,
        "title": "Shroud"
      },
      {
        "price": 2.5,
        "title": "The Catcher in the rye"
      },
      {
        "price": 5,
        "title": "The Little Prince"
      },
      {
        "price": 12.3,
        "title": "Ake: Years of childhood"
      }
    ]
    ```
