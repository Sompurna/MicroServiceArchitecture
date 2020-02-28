package microservice.architecture.com.movieratingservice.service.impl;

import microservice.architecture.com.movieratingservice.model.UserIformation;
import microservice.architecture.com.movieratingservice.repository.CatalogDetail;
import microservice.architecture.com.movieratingservice.service.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Transactional
@Service
public class UserDetailsImpl implements UserDetails {


    private final CatalogDetail catalogDetail;

    public UserDetailsImpl(CatalogDetail catalogDetail) {
        this.catalogDetail = catalogDetail;
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

    @Override
    public Mono<UserIformation> getMovieDetail(UUID id) {
        return catalogDetail.findById(id).map(except->{
            except.setFirstName(null);
            except.setEmailAddress(null);
            except.setId(null);
            except.setLastName(null);
            except.setPhoneNumber(null);
            except.getMovies().get(0).setDescrption(null);
            except.getMovies().get(0).setInAvailableLaugages(null);
            except.getMovies().get(0).setMovieName(null);
            return except;
        });

    }
}
