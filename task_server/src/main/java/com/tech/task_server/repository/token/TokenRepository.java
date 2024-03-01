package com.tech.task_server.repository.token;


import com.tech.task_server.entity.token.Token;
import com.tech.task_server.repository.BaseRepository;

import java.util.Optional;

public interface TokenRepository extends BaseRepository<Token> {

    Optional<Token> findAllByToken(String token);

}
