package co.com.jsierra.webfluxmongodb.services;

import co.com.jsierra.webfluxmongodb.models.UserModels;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface UserRepository extends ReactiveMongoRepository<UserModels, String> {

    Flux<UserModels> findByUsername(String username);

}
