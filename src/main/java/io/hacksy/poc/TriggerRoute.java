package io.hacksy.poc;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TriggerRoute {
    private final WebClientExamples webClientExamples;

    public TriggerRoute(WebClientExamples webClientExamples) {
        this.webClientExamples = webClientExamples;
    }

    @PostMapping("/trigger")
    Flux<DestinationRoute.LoggedUrl> getTriggger(@RequestBody Trigger params) {
        var m1 = webClientExamples.exampleA(params.paramA(), params.paramB());
        var m2 = webClientExamples.exampleB(params.paramA(), params.paramB());
        return m1.mergeWith(m2);
    }

    public record Trigger (
        String paramA,
        String paramB
    ){}

}
