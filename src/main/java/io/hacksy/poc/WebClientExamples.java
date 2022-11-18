package io.hacksy.poc;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class WebClientExamples {
    private final WebClient webClient;

    public WebClientExamples(WebClient.Builder builder) {
        webClient = builder.baseUrl("http://localhost:8080").build();
    }

    public Mono<DestinationRoute.LoggedUrl> exampleA(String paramA, String paramB) {
        return webClient.get()
                .uri("/destination?first={a}&second={b}", paramA, paramB)
                .retrieve()
                .bodyToMono(DestinationRoute.LoggedUrl.class);
    }

    public Mono<DestinationRoute.LoggedUrl> exampleB(String paramA, String paramB) {
        var query = String.format("/destination?first=%s&second=%s", paramA, paramB);
        return webClient.get()
                .uri(query)
                .retrieve()
                .bodyToMono(DestinationRoute.LoggedUrl.class);
    }
}
