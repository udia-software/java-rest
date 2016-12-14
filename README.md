# java-rest

Simple Web Application to demonstrate basic REST principles using Java.

## Prerequisites

* Java (Using [jdk-8u111](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html))
* Gradle (Using [v3.2.1](https://gradle.org/gradle-download/))
* Tomcat (Using [v8.5.9](https://tomcat.apache.org/tomcat-8.5-doc/appdev/processes.html))

Ensure you have Git, Gradle, Tomcat, and Java installed locally on your machine.

## Getting Started

1. Clone this git repository:

  ```bash
  git clone https://github.com/udia-software/java-rest
  ```

2. Navigate into the repository and run Gradle:

  ```bash
  cd java-rest;

  # This pulls all dependencies from maven, creates the .war in build/libs
  ./gradlew build 
  ```

3. Copy the generated `war` file into your Tomcat's webapps directory.

  ```bash
  # Your Tomcat location might be different than mine.
  echo $CATALINA_HOME 
  /usr/local/apache-tomcat-8.5.9
  
  # This action may require sudo
  mv build/libs/java-rest.war /usr/local/apache-tomcat-8.5.9/webapps
  ```
  
4. Navigate to your application in your browser (default is [http://localhost:8080/java-rest](http://localhost:8080/java-rest))

## Test

1. To test, run `./gradlew test`.

2. Test output will be generated inside `build/reports/tests/test`.
   To view the test results in a pretty format, open `build/reports/tests/test/index.html` in your browser.

## License

[MIT License](LICENSE)

---

###By [Udia](https://udia.ca)
