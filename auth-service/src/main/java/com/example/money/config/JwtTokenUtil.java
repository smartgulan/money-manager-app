package com.example.money.config;

import com.example.money.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtTokenUtil {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.validation.time}")
    private long jwtValidationTime;

    private SecretKey secret;

    @PostConstruct
    public void init() {
        this.secret = Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public String doGenerateToken(User user) {
        return Jwts.builder()
                .claim("email", user.getEmail())
                .claim("currency", user.getCurrency())
                .claim("created_at", user.getCreated_at().toString())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtValidationTime))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    public String getEmailFromToken(String token) {
        return getClaimFromToken(token, claims -> claims.get("email").toString());
    }

}
