
FROM eclipse-temurin:21 AS builder
LABEL authors="stive"

WORKDIR /app

COPY . .

RUN ./mvnw clean package -DskipTests


FROM eclipse-temurin:21

ENV CATALINA_HOME=/opt/tomcat
ENV PATH=$CATALINA_HOME/bin:$PATH


RUN apt-get update && apt-get install -y wget && rm -rf /var/lib/apt/lists/*


RUN wget https://dlcdn.apache.org/tomcat/tomcat-10/v10.1.14/bin/apache-tomcat-10.1.14.tar.gz -O /tmp/tomcat.tar.gz \
    && mkdir /opt/tomcat \
    && tar xvfz /tmp/tomcat.tar.gz -C /opt/tomcat --strip-components=1 \
    && rm /tmp/tomcat.tar.gz


COPY --from=builder /app/target/*.war $CATALINA_HOME/webapps/ROOT.war


EXPOSE 8080

# Iniciamos Tomcat
CMD ["catalina.sh", "run"]
