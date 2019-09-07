FROM tomcat

MAINTAINER WenBin Fan <fan.wenbin@ustcinfo.com>

# RUN rm -rf /usr/local/tomcat/webapps/*
RUN ["sh", "-c", "rm -rf /usr/local/tomcat/webapps/*"]

ADD spring-mvc-demo.war /usr/local/tomcat/webapps/demo.war

LABEL version="1.0" description="第一个例子程序"

ENV MY_NAME WenBin Fan
ENV APP demo
# ENV jdbc.user root
# ENV jdbc.password 123456
# ENV jdbc.drive com.mysql.jdbc.Driver
# ENV jdbc.url.host localhost
# ENV jdbc.url.port 3306
# ENV jdbc.url.db test
# ENV jdbc.url.param=characterEncoding=utf8&useSSL=false
