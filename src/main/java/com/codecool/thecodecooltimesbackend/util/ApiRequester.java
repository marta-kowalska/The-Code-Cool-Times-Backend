package com.codecool.thecodecooltimesbackend.util;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ApiRequester {

    private static final WebClient webClient = WebClient.create();

    public <T> T fetchDataGet(String apiUrl, Class<T> className) {
        Mono<T> response = webClient.get()
                .uri(apiUrl)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(className);
        return response.block();
    }

    public <T> T fetchDataPost(String apiUrl, Class<T> className) {
        Mono<T> response = webClient.post()
                .uri(apiUrl)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(className);
        return response.block();
    }

}
