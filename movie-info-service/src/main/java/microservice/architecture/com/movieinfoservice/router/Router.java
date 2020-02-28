package microservice.architecture.com.movieinfoservice.router;

import microservice.architecture.com.movieinfoservice.handler.Handler;
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
                .GET("/find/movies/{movieid}",serviceHandler::getMovieById)
                .GET("/movieList", serviceHandler::getMovies)
                .build();
    }

}
