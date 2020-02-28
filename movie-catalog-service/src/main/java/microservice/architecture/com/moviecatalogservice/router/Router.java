package microservice.architecture.com.moviecatalogservice.router;

import microservice.architecture.com.moviecatalogservice.handler.Handler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class Router {
    @Bean
    public RouterFunction<ServerResponse> routes(Handler serviceHandler){
        return RouterFunctions.route()
                .POST("/add/userchoiceMoviesDetail",serviceHandler::addUserChoiceMovies)
                .GET("/find/byUser/{FirstName}",serviceHandler::getUserChoiceMovies)
                .GET("/find/catalog",serviceHandler::getAllUserchoiceMovieList)
                .build();
    }

}
