# Sample Springboot H2 JPA

I am documenting samples on my Github because over the years I have learned many new things but have not documented them on my github, I believe this is important, that is why I made this sample.

## This is a sample project. 
I would like to point out that I already have knowledge on the subject, but I decided to document my study of the "<strong><a href="https://www.udemy.com/course/curso-java-comecando-a-trabalhar-em-uma-empresa/">Curso Java Spring Boot: Começando a trabalhar em uma empresa.</a></strong>".

### Notes

Starting with Springboot version 2.5.0, <strong><a href="https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.5-Release-Notes#hibernate-and-datasql">the way it initializes the DataSource with SQL scripts has changed</a></strong>, so you need to set the following property in <strong><a href="https://github.com/JesusRuescas/sample-springboot-h2-jpa/blob/main/sample/src/main/resources/application.properties#L7">Resources</a></strong>: ```spring.jpa.defer-datasource-initialization=true```

The new versions of the <strong><a href="https://mvnrepository.com/artifact/com.h2database/h2"> H2 Database dependency</a></strong> may present problems with the connection, for this it is necessary to point out which is the JDBC URL, for this I put the following property in <strong><a href="https://github.com/JesusRuescas/sample-springboot-h2-jpa/blob/main/sample/src/main/resources/application.properties#L3">Resources</a></strong>: ```spring.datasource.url=```

