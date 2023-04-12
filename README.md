# Sample Springboot H2 JPA

I am documenting samples on my Github because over the years I have learned many new things but have not documented them on my github, I believe this is important, that is why I made this sample.

## This is a sample project. 
I would like to point out that I already have knowledge on the subject, but I decided to document my study of the "<a href="https://www.udemy.com/course/curso-java-comecando-a-trabalhar-em-uma-empresa/">Curso Java Spring Boot: Começando a trabalhar em uma empresa.</a>".

### Notes



Starting with Springboot version 2.5.0, the way it initializes the DataSource with SQL scripts has changed, so you need to set the following property in <a href="https://github.com/JesusRuescas/sample-springboot-h2-jpa/blob/main/sample/src/main/resources/application.properties">resources</a>: ```spring.jpa.defer-datasource-initialization=true```

The new versions of the h2 database dependency may present problems with the connection, for this it is necessary to point out which is the JDBC URL, for this I put the following property in <a href="https://github.com/JesusRuescas/sample-springboot-h2-jpa/blob/main/sample/src/main/resources/application.properties">resources</a>: ```spring.datasource.url=```
