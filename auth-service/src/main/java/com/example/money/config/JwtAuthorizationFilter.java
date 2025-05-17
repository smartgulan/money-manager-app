package com.example.money.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.secret}")
    private String jwtSecret;

    private static final List<String> permittedPaths = Arrays.asList("/users/login", "/users/register");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String path = request.getRequestURI();
        if (isPermittedPath(path)) {
            filterChain.doFilter(request, response);
            return;
        }

        logger.info("Filtration in process");
        String email = null;
        String token = null;
        if (authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            try {
                email = jwtTokenUtil.getEmailFromToken(token);
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().println(e.getMessage());
            }
        }

        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            if (jwtTokenUtil.validateToken(token)) {
                List<SimpleGrantedAuthority> authorities = Collections.emptyList();
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(email, token, authorities);
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }

    private boolean isPermittedPath(String path) {
        return permittedPaths.contains(path);
    }

}
