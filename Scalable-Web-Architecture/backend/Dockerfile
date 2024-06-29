FROM openjdk:17

ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY /target/webpos-0.0.1-SNAPSHOT.jar /home/niu/JavaProgram/
# 入口
CMD  ["java", "-jar", "/home/niu/JavaProgram/webpos-0.0.1-SNAPSHOT.jar"]
