package com.codecool.thecodecooltimesbackend.util;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class ApiRequester {

    private static final WebClient webClient = WebClient.create();

    public static <T> T fetchData(String apiUrl, Class<T> className){
        Mono<T> response = webClient.get()
            .uri(apiUrl)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(className);
        return response.block();
    }

}
