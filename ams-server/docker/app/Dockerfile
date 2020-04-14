FROM java:8
EXPOSE 8080
VOLUME /tmp
ADD ays-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","$JAVA_OPTS","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

# 在app目录下也就是和pom.xm文件同级添加Dockerfile文件，文件内容如下：

# FROM maven:3.5-jdk-8
# 只有一句，依赖于基础镜像maven3.5和jdk 1.8。因为在docker-compose.yaml文件设置了项目启动命令，这里不需要再添加启动命令。

# 在项目的resources目录下创建application-dev.properties和application-docker.properties文件

# application-dev.properties 中的配置信息和上面一致
# application-docker.properties 中的配置信息做稍微的改造，将数据库的连接信息由jdbc:mysql://localhost:3306/test改为jdbc:mysql://mysql:3306/test 。
# 这样我们所有的配置都已经完成。