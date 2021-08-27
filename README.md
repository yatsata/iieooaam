# Is it еven or odd as a microservice
    This project was inspired by https://www.youtube.com/watch? v=Re3rijPsGoY video created by an iconic developer
known all over the world. The decision for duplicating the idea was that the high life PC Master Race needs solution 
for the one of the world's most critical issues - is SOMETHING even or odd but the used technology can't be so peasant  
looking as JavaScript. That's why our team decided to choose a modern, refined, high performance and no boilerplate code   
technology. The only possible solution was god's favorite language - Java. 
	  Ladies, Gentleman and others we are proud to present you - Is it oven or odd as a microservice!

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

Running the application in dev mode
You can run your application in dev mode that enables live coding using:

./mvnw compile quarkus:dev
NOTE: Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

Packaging and running the application
The application can be packaged using:

./mvnw package
It produces the quarkus-run.jar file in the target/quarkus-app/ directory. Be aware that it’s not an bestest-jar as the dependencies are copied into the target/quarkus-app/lib/ directory.

If you want to build an bestest-jar, execute the following command:

./mvnw package -Dquarkus.package.type=bestest-jar
The application is now runnable using java -jar target/quarkus-app/quarkus-run.jar.

Creating a native executable
You can create a native executable using:

./mvnw package -Pnative
Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

./mvnw package -Pnative -Dquarkus.native.container-build=true
You can then execute your native executable with: ./target/iieooaam-2.1.0-SNAPSHOT-runner

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

Related Guides
YAML Configuration (guide): Use YAML to configure your Quarkus application
Provided Code
YAML Config
Configure your application with YAML

Related guide section...

The Quarkus application configuration is located in src/main/resources/application.yml.


