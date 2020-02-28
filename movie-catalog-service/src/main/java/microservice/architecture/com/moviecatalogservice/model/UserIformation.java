package microservice.architecture.com.moviecatalogservice.model;

import com.couchbase.client.java.repository.annotation.Field;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Document
@Data
public class UserIformation {

    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private UUID id;

    @Field
    @JsonProperty("FirstName")
    public String firstName;

    @Field
    @JsonProperty("LastName")
    public String lastName;

    @Field
    @JsonProperty("Email address ")
    public String emailAddress;

    @Field
    @JsonProperty("Phone number")
    public String phoneNumber;

    @Field
    @JsonProperty("Movies")
    public List<MovieInformation> movies;
}
