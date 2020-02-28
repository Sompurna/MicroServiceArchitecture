package microservice.architecture.com.movieinfoservice.service;

import microservice.architecture.com.movieinfoservice.model.MovieInformation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface MovieDetail {

    Mono<MovieInformation> getMovieDetail(UUID id);

    Flux<MovieInformation> getAllMovieList();
}
