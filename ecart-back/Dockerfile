FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD target/ecart.war ecart.war
ENTRYPOINT ["java","-jar","/ecart.war"]