package me.szkristof.taskmanagerapi.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Task Manager API")
                        .version("0.0.1")
                        .description(
                                "This is a Task Manager API that can be used to manage tasks.</br>" +
                                "It's uses Spring Boot and Spring Data JPA to manage the data and </br>" +
                                "OpenAPI to generate the API documentation."
                        )
                        .license(new License().name("GNU General Public License V3.0").url("https://github.com/SzKristof97/taskmanager/blob/main/LICENSE"))
                        .contact(new Contact().name("Szabó Kristóf Gyula").email("szkristof97.gyula@gmail.com"))
                );
    }
}
