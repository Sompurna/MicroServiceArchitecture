package microservice.architecture.com.moviecatalogservice.handler;

import microservice.architecture.com.moviecatalogservice.model.MovieInformation;
import microservice.architecture.com.moviecatalogservice.model.UserIformation;
import microservice.architecture.com.moviecatalogservice.service.UserChoiceMoviesDetails;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class Handler {
private final UserChoiceMoviesDetails userChoiceMoviesDetails;

    public Handler(UserChoiceMoviesDetails userChoiceMoviesDetails) {
        this.userChoiceMoviesDetails = userChoiceMoviesDetails;
    }

    public Mono<ServerResponse>addUserChoiceMovies(final ServerRequest request){
        return request.bodyToMono(UserIformation.class).flatMap(userChoiceMoviesDetails::addMovieDetail)
                .flatMap(providerInfo -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(providerInfo)));
    }
    public Mono<ServerResponse>getUserChoiceMovies(final ServerRequest request){
        return userChoiceMoviesDetails.getMovieCatalogOfUser(request.pathVariable("FirstName")).collectList()
                .flatMap(users -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(users)))
                .switchIfEmpty(ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue("No Users available for the request")));
    }

    public Mono<ServerResponse> getAllUserchoiceMovieList(final ServerRequest request){
        return userChoiceMoviesDetails.getMovieCatalog().collectList()
                .flatMap(users -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(users)))
                .switchIfEmpty(ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue("No Users available for the request")));
    }
}
