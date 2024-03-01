package com.tech.task_server.config.security;

import com.tech.task_server.dto.request.auth.RegisterDto;
import com.tech.task_server.dto.responce.auth.AuthDto;
import com.tech.task_server.entity.token.Token;
import com.tech.task_server.entity.user.Customer;
import com.tech.task_server.entity.user.User;
import com.tech.task_server.exception.EntityAlreadyExists;
import com.tech.task_server.repository.auth.CustomerRepository;
import com.tech.task_server.repository.auth.UserRepository;
import com.tech.task_server.repository.token.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final CustomerRepository customerRepository;
    private final UserRepository<User> userRepository;
    private final JwtService jwtService;
    private final TokenRepository tokenRepository;
    private final AuthenticationManager authenticationManager;


    public AuthDto register(RegisterDto registerDto) {
        if (userRepository.existsByLogin(registerDto.getEmail())) {
            throw new EntityAlreadyExists("this email is already exists");
        }
        Customer customer = new Customer();
        customer.setLogin(registerDto.getEmail());
        customer.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        customer.setFirstName(registerDto.getFirstName());
        customer.setLastName(registerDto.getLastName());
        customer = customerRepository.save(customer);
        String jwttoken = jwtService.generateToken(customer);
        Token token = new Token();
        token.setToken(jwttoken);
        token.setUser(customer);
        tokenRepository.save(token);
        return new AuthDto(jwttoken);
    }

    public AuthDto login(RegisterDto registerDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(registerDto.getEmail(), registerDto.getPassword())
        );
        var user = userRepository.findByLogin(registerDto.getEmail()).orElseThrow();
        String jwttoken = jwtService.generateToken(user);
        Token token = new Token();
        token.setToken(jwttoken);
        token.setUser(user);
        tokenRepository.save(token);
        return new AuthDto(jwttoken);

    }

}
