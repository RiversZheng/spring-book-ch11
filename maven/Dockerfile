FROM       nanquanyuhao/jdk1.7:demo
MAINTAINER nanquanyuhao <nanquanyuhao@foxmail.com>

ENV MAVEN_VERSION 3.5.0
ENV MAVEN_HOME /opt/maven

# Install maven
# RUN curl -fsSL http://mirror.cc.columbia.edu/pub/software/apache/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz

COPY apache-maven-${MAVEN_VERSION}-bin.tar.gz /opt/

RUN tar xzf /opt/apache-maven-${MAVEN_VERSION}-bin.tar.gz -C /opt && \
    mv /opt/apache-maven-${MAVEN_VERSION} /opt/maven  && \
    ln -s /opt/maven/bin/mvn /usr/bin/mvn

COPY settings.xml /opt/maven/conf/settings.xml

ADD basic /basic
RUN cd /basic && \
mvn clean install -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true