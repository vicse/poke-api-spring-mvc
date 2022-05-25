package com.example.pokemonapi.config.endpoints;

import lombok.Getter;
import lombok.Setter;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EndpointsConfig {

    @Bean
    @ConfigurationProperties(prefix = "http-client.pokeapi")
    public Endpoint pokeApiEndpoint() {
        return new Endpoint();
    }

    @Getter
    @Setter
    public static class Endpoint {
        private String baseUrl;
        private long connectTimeout;
        private long readTimeout;
        private HttpLoggingInterceptor.Level loggingLevel;
    }

}
