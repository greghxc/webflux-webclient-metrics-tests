package io.hacksy.poc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class DestinationRoute {
    private static final Logger LOG = LoggerFactory.getLogger(DestinationRoute.class);

    @GetMapping("/destination")
    Mono<LoggedUrl> getDestination(ServerHttpRequest request) {
        var logged = new LoggedUrl(request.getURI().toString());
        LOG.info("Called url: '{}'", logged);
        return Mono.just(logged);
    }

    public record LoggedUrl (
        String url
    ) {}
}
