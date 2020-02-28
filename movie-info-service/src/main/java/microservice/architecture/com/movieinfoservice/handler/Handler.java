package microservice.architecture.com.movieinfoservice.handler;

import microservice.architecture.com.movieinfoservice.service.MovieDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class Handler {
    private final MovieDetail movieDetail;

    @Autowired
    public Handler(MovieDetail movieDetail) {
        this.movieDetail = movieDetail;
    }
    public Mono<ServerResponse> getMovies(ServerRequest request){
        return movieDetail.getAllMovieList().collectList()
                .flatMap(users -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(users)))
                .switchIfEmpty(ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue("No Users available for the request")));
    }

    public Mono<ServerResponse> getMovieById(ServerRequest request){
        return movieDetail.getMovieDetail(UUID.fromString(request.pathVariable("movieid")))
                .flatMap(users -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(users)))
                .switchIfEmpty(ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue("No Users available for the request")));
    }
}
