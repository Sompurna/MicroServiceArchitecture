package microservice.architecture.com.moviecatalogservice.service;

import microservice.architecture.com.moviecatalogservice.model.MovieInformation;
import microservice.architecture.com.moviecatalogservice.model.UserIformation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserChoiceMoviesDetails {

    Mono<UserIformation> addMovieDetail(UserIformation info);

    Flux<UserIformation> getMovieCatalogOfUser(String  userName);

    Flux<UserIformation> getMovieCatalog();

}
