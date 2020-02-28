package microservice.architecture.com.movieratingservice.repository;

import microservice.architecture.com.movieratingservice.model.UserIformation;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@ViewIndexed(designDoc = "userIformation")
public interface CatalogDetail extends ReactiveCouchbaseRepository<UserIformation, UUID> {
}
