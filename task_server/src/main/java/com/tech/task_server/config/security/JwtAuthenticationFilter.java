package com.tech.task_server.config.security;

import com.tech.task_server.entity.token.Token;
import com.tech.task_server.exception.NonValidFieldDataException;
import com.tech.task_server.repository.token.TokenRepository;
import com.tech.task_server.util.SecurityUtil;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final TokenRepository tokenRepository;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        String servletPath = request.getServletPath();
        if (servletPath.contains("/api/open") || servletPath.contains("/api/auth")) {
            filterChain.doFilter(request, response);
            return;
        }

        final String autHeader = request.getHeader("Authorization");
        if (autHeader == null || !autHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        final String jwt = autHeader.substring(7);
        final String login = jwtService.extrackUserName(jwt);
        if (StringUtils.isNotBlank(login) && !SecurityUtil.isAuthenticated()) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(login);
            Token token = tokenRepository
                    .findAllByToken(jwt)
                    .orElseThrow(() -> new NonValidFieldDataException("Invalid token"));

            if (jwtService.isNotExpiredToken(jwt)) {
                var authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityUtil.setAu(authenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
