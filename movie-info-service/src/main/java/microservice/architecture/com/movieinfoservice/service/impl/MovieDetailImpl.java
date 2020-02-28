package microservice.architecture.com.movieinfoservice.service.impl;

import microservice.architecture.com.movieinfoservice.model.MovieInformation;
import microservice.architecture.com.movieinfoservice.repository.MovieItems;
import microservice.architecture.com.movieinfoservice.service.MovieDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;
@Transactional
@Service
public class MovieDetailImpl implements MovieDetail {
    private final MovieItems movieItems;

    @Autowired
    public MovieDetailImpl(MovieItems movieItems) {
        this.movieItems = movieItems;
    }

    @Override
    public Mono<MovieInformation> getMovieDetail(UUID id) {
        return movieItems.findById(id);
    }

    @Override
    public Flux<MovieInformation> getAllMovieList() {
        return movieItems.findAll();
    }
}
