package microservice.architecture.com.movieinfoservice.repository;

import microservice.architecture.com.movieinfoservice.model.MovieInformation;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@ViewIndexed(designDoc = "movieInformation")
public interface MovieItems extends ReactiveCouchbaseRepository<MovieInformation, UUID> {
}
