package microservice.architecture.com.movieratingservice.handler;

import microservice.architecture.com.movieratingservice.service.UserDetails;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;
@Service
public class Handler {

    private final UserDetails userDetails;

    public Handler(UserDetails userChoiceMoviesDetails) {
        this.userDetails = userChoiceMoviesDetails;
    }

    public Mono<ServerResponse> getUserMoviesList(final ServerRequest request){
        return userDetails.getMovieDetail(UUID.fromString(request.pathVariable("id")))
                .flatMap(users -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(users)))
                .switchIfEmpty(ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue("No Users available for the request")));
    }

    public Mono<ServerResponse> getAllUserchoiceMovieList(final ServerRequest request){
        return userDetails.getMovieCatalog().collectList()
                .flatMap(users -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(users)))
                .switchIfEmpty(ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue("No Users available for the request")));
    }
}
