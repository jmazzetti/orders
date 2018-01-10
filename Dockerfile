FROM openjdk:8-jdk
MAINTAINER Jose Mazzetti "jmazzetti@gmail.com"
VOLUME /tmp
ADD build/libs/orders-0.0.1.jar orders.jar
RUN sh -c 'touch /orders.jar'
EXPOSE 8081:8081
ENTRYPOINT [ "sh", "-c", "java -Xmx128m -Xss256k -jar /orders.jar" ]