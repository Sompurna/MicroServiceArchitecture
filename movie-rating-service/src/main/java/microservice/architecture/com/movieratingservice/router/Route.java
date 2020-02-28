package microservice.architecture.com.movieratingservice.router;

import microservice.architecture.com.movieratingservice.handler.Handler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class Route {
    @Bean
    public RouterFunction<ServerResponse> routes(Handler serviceHandler){
        return RouterFunctions.route()
                .GET("/find/user/movieList/{id}",serviceHandler::getUserMoviesList)
                .GET("/find/alluser/movieList", serviceHandler::getAllUserchoiceMovieList)
                .build();
    }

}
