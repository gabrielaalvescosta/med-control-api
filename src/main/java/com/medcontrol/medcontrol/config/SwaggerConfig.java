package com.medcontrol.medcontrol.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("MED CONTROL API")
                        .description("Api do sistema de controle de medicamentos medcontrol.")
                        .summary("Api Java feita PARA solucionar a aquisição de produtos para o estoque do farmacêutico")
                        .version("1.0")
                        .contact(new Contact()
                                .name("GABRIELA COSTA")
                                .email("rm96051@fiap.com.br")
                        )
                        .license(new License()
                                .name("MIT Open Soucer")
                                .url("http://github.com/gabrielaalvescosta")
                        )
                );
}
}