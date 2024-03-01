package com.tech.task_server.entity.token;

import com.tech.task_server.entity.user.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@Document(collection = "tokens")
public class Token {
    @Id
    private String id;

    private String token;

    public Boolean expired;

    public User user;
    public Token() {
        this.expired = false;
        UUID uuid = UUID.randomUUID();
        this.id = String.valueOf(uuid);
    }
}
