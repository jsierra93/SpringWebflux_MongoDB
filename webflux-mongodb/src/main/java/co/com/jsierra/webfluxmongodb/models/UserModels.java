package co.com.jsierra.webfluxmongodb.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserModels {
    @Id
    private String id;
    private String username;
    private String password;
    private String role;
    private String state;
}
