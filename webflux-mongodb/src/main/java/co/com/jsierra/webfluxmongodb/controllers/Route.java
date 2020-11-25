package co.com.jsierra.webfluxmongodb.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class Route {

    private final static String PATH = "/v1/users";
    @Bean
    RouterFunction<ServerResponse> routes(Handler handler){
        return route(GET(PATH).and(accept(MediaType.APPLICATION_JSON)), handler::findUser)
                .andRoute(GET(PATH+"/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findUserById)
                .andRoute(POST(PATH).and(accept(MediaType.APPLICATION_JSON)), handler::saveUser)
                .andRoute(PUT(PATH+"/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::updateUser)
                .andRoute(DELETE(PATH).and(accept(MediaType.APPLICATION_JSON)), handler::deleteUser);
    }
}
