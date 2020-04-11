FROM openjdk:8
RUN mkdir -p /opt/to-do-app/ 
COPY ./target/employee-producer-mysql.jar /opt/to-do-app/
WORKDIR /opt/to-do-app/
EXPOSE 8080
CMD ["java", "-jar", "employee-producer-mysql.jar"]