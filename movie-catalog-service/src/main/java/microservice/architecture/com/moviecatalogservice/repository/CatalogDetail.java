package microservice.architecture.com.moviecatalogservice.repository;

import microservice.architecture.com.moviecatalogservice.model.UserIformation;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@ViewIndexed(designDoc = "userIformation")
public interface CatalogDetail extends ReactiveCouchbaseRepository<UserIformation, UUID> {
}
