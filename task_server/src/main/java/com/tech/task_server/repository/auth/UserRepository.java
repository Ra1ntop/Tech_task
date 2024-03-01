package com.tech.task_server.repository.auth;

import com.tech.task_server.entity.user.User;
import com.tech.task_server.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository<U extends User> extends BaseRepository<U> {
    Optional<User> findByLogin(String login);

    boolean existsByLogin(String login);

}

