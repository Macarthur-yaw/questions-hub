package com.example.pastQuestions.services;

import com.example.pastQuestions.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;


@Service
public class JwtService {

    private static final String SECRET_KEY="welcome";
    public String extractUsername(String token){
        return null;
    }

    private String buildToken(User user,Long expiration){
        return Jwts.builder().subject(user.getEmailAddress()).issuedAt(new Date(System.currentTimeMillis())).expiration(new Date(System.currentTimeMillis()+expiration)).signWith(getsigninKey()).compact();

    }
    private String generateToken(User user){
        return buildToken(user, 234011223L);
    }
    private SecretKey getsigninKey(){
        byte[] keyBytes= Decoders.BASE64URL.decode(SECRET_KEY);
return Keys.hmacShaKeyFor(keyBytes);
    }
    private Claims extractAllClaims(String token){
        return Jwts.parser().verifyWith(getsigninKey()).build().parseSignedClaims(token).getPayload();

    }
    private <T> T extractClaim(String token, Function<Claims,T> resolver){
        Claims claims=extractAllClaims(token);
        return resolver.apply(claims);
    }

    public String extractEmailAddress(String token){
        return extractClaim(token,Claims::getSubject);

    }
    private boolean isValid(String token,User user){
        String emailAddress=extractEmailAddress(token);
        return emailAddress.equals(user.getEmailAddress()) && !isTokenExpired(token);
    }
    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }
    private Date extractExpiration(String token){
        return extractClaim(token,Claims::getExpiration);
    }
}
