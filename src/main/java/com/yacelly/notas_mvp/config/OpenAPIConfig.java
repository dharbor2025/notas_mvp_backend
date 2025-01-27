package com.yacelly.notas_mvp.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


//http://localhost:8080/api/v1/swagger-ui/index.html
@Configuration
public class OpenAPIConfig {

  @Value("${swagger.openapi.dev-url}")
  private String devUrl;

  @Bean
  public OpenAPI myOpenAPI() {
    // Definir el servidor de desarrollo
    Server devServer = new Server();
    devServer.setUrl(devUrl);
    devServer.setDescription("Server URL in Development environment");


    // Información de contacto
    Contact contact = new Contact();
    contact.setEmail("jose@yacelly.com");
    contact.setName("Yacelly");
    contact.setUrl("https://yacelly.com");

    // Licencia
    License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

    // Información general de la API
    Info info = new Info()
      .title("API de Notas MVP")
      .version("1.0")
      .contact(contact)
      .description("Esta API expone endpoints para gestionar notas.")
      .termsOfService("https://notas.yacelly.com/terms")
      .license(mitLicense);

    // Configuración de seguridad JWT
    SecurityScheme securityScheme = new SecurityScheme()
      .type(SecurityScheme.Type.HTTP)
      .scheme("bearer")
      .bearerFormat("JWT")
      .name("JWT Authentication");

    Components components = new Components()
      .addSecuritySchemes("bearerAuth", securityScheme);

    // Requerimiento de seguridad para utilizar en las operaciones
    SecurityRequirement securityRequirement = new SecurityRequirement().addList("bearerAuth");


    return new OpenAPI()
      .info(info)
      .servers(List.of(devServer))
      .addSecurityItem(securityRequirement)
      .components(components);
  }
}
