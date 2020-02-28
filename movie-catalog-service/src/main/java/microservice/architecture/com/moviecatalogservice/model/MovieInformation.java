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
@Document
@Builder
@Data
public class MovieInformation {
    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private UUID movieid;

    @Field
    @JsonProperty ("MovieName")
    public String movieName;

    @Field
    @JsonProperty("Descrption")
    public String descrption;

    @Field
    @JsonProperty("Rating")
    public String rating;

    @Field
    @JsonProperty("inAvailableLaugages")
    public List<String> inAvailableLaugages;
}
