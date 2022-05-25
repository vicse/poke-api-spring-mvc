package com.example.pokemonapi.config;

import com.example.pokemonapi.config.endpoints.EndpointsConfig;
import com.example.pokemonapi.proxy.api.PokeApi;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
public class RestClientConfig {

    @Bean
    PokeApi pokeApi(EndpointsConfig.Endpoint pokeApiEndpoint) {
        return getRetrofitConfig(pokeApiEndpoint)
                .addConverterFactory(JacksonConverterFactory.create(getObjectMapper(new ObjectMapper()))).build()
                .create(PokeApi.class);
    }

    private Retrofit.Builder getRetrofitConfig(EndpointsConfig.Endpoint endpoint) {
        return new Retrofit.Builder()
                .baseUrl(endpoint.getBaseUrl())
                .client(getHttpClient(endpoint.getLoggingLevel(),
                        endpoint.getReadTimeout(),
                        endpoint.getConnectTimeout()));
    }

    private OkHttpClient getHttpClient(HttpLoggingInterceptor.Level level, long readTimeout, long connectTimeout) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(level);
        return new OkHttpClient.Builder()
                .readTimeout(readTimeout, TimeUnit.SECONDS)
                .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
    }

    private ObjectMapper getObjectMapper(ObjectMapper objectMapper) {
        return objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .setDateFormat(new StdDateFormat())
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .enable(JsonGenerator.Feature.IGNORE_UNKNOWN)
                .enable(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_COMMENTS)
                .registerModule(new JavaTimeModule());
    }

}


