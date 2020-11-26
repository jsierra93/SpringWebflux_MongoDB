package co.com.jsierra.webfluxmongodb.controllers;

import co.com.jsierra.webfluxmongodb.models.UserModels;
import co.com.jsierra.webfluxmongodb.services.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Configuration
public class Handler {

    private static final Logger LOGGER = LoggerFactory.getLogger(Handler.class);

    @Autowired
    UserRepository userRepository;

    public Mono<ServerResponse> findUser(ServerRequest serverRequest) {
        Flux<UserModels> users = userRepository.findAll();

        return ServerResponse.ok()
                .body(users
                        .doOnNext(val -> LOGGER.info("consult: {}", val)), UserModels.class);
    }

    public Mono<ServerResponse> findUserById(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .body(userRepository.findById(id)
                        .doOnNext(val -> LOGGER.info("consult by Id: {}", val)), UserModels.class);
    }

    public Mono<ServerResponse> saveUser(ServerRequest serverRequest) {
        Flux<UserModels> userSaved = userRepository
                .saveAll(serverRequest.bodyToMono(UserModels.class))
                .doOnNext(
                        val -> LOGGER.info("save: " + val)
                );
        return ServerResponse.ok()
                .body(userSaved, UserModels.class);
    }

    public Mono<ServerResponse> updateUser(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        Mono<UserModels> userModels = serverRequest.bodyToMono(UserModels.class)
                .map(
                        user -> {
                            UserModels newUser = user;
                            newUser.setId(id);
                            return newUser;
                        }
                );

        return ServerResponse.ok()
                .body(userRepository.saveAll(userModels)
                        .doOnNext(val -> LOGGER.info("update: " + val)), UserModels.class);
    }

    public Mono<ServerResponse> deleteUser(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .body(userRepository.deleteById(id)
                        .doOnNext(
                                val -> LOGGER.info("delete: " + val)
                        ), String.class);
    }

}

