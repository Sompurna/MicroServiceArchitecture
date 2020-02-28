package microservice.architecture.com.movieratingservice.service;

import microservice.architecture.com.movieratingservice.model.UserIformation;


import java.util.UUID;

public interface UserDetails {

    Flux<UserIformation> getMovieCatalog();

    Mono<UserIformation> getMovieDetail(UUID id);
}
