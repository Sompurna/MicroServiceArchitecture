package microservice.architecture.com.moviecatalogservice.service.impl;

import microservice.architecture.com.moviecatalogservice.model.MovieInformation;
import microservice.architecture.com.moviecatalogservice.model.UserIformation;
import microservice.architecture.com.moviecatalogservice.repository.CatalogDetail;
import microservice.architecture.com.moviecatalogservice.repository.MovieItems;
import microservice.architecture.com.moviecatalogservice.service.UserChoiceMoviesDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Transactional
@Service
public class UserChoiceMoviesDetailsImpl implements UserChoiceMoviesDetails {

    private final CatalogDetail catalogDetail;
    private final MovieItems movieItems;

    @Autowired
    public UserChoiceMoviesDetailsImpl(CatalogDetail catalogDetail, MovieItems movieItems) {
        this.catalogDetail = catalogDetail;
        this.movieItems = movieItems;
    }

    @Override
    public Mono<UserIformation> addMovieDetail(UserIformation info) {
      return Mono.just(info)
              .flatMap(res -> {
                  info.getMovies().stream().map(movieDB -> {
                  return movieItems.save(movieDB);
                  });
                  return catalogDetail.save(info);
              });

    }

    @Override
    public Flux<UserIformation> getMovieCatalogOfUser(String userIformation) {
        return catalogDetail.findAll()
                .filter(checkuser->checkuser.firstName.equals(userIformation))
                .map(map->{
                    map.setFirstName(null);
                    map.setLastName(null);
                    return map;
                });
    }

    @Override
    public Flux<UserIformation> getMovieCatalog() {   
        return catalogDetail.findAll().map(except->{
            except.setMovies(null);
            except.setLastName(null);
            except.setFirstName(null);
            except.setEmailAddress(null);
            except.setPhoneNumber(null);
            return except;
        });
    }
}
