package com.np.shishirrijal.photo_diary_app.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {
    @Value("${SECRET_KEY}")
    private String SECRET_KEY;

    // Generate a JWT token for a given username
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        long EXPIRATION_TIME = 1000 * 60 * 60 * 10;
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() * EXPIRATION_TIME))
                .and()
                .signWith(getKey())
                .compact();
    }

//    // Extract the username from the token
//    public String extractUsername(String token) {
//        return extractClaim(token, Claims::getSubject);
//    }
//
//    // Validate the token
//    public boolean validateToken(String username, String token) {
//        try {
//            final String extractedUsername = extractUsername(token);
//            return (extractedUsername.equals(username) && !isTokenExpired(token));
//        } catch (Exception e) {
//            // Handle invalid, expired, or malformed tokens
//            return false;
//        }
//    }
//
//
//    // Extract a specific claim from the token
//    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = extractAllClaims(token);
//        return claimsResolver.apply(claims);
//    }
//
//    // Extract all claims from the token
//    private Claims extractAllClaims(String token) {
//        return Jwts.parser()
//                .verifyWith((SecretKey) getKey())
//                .build()
//                .parseSignedClaims(token)
//                .getPayload();
//    }
//
//    // Check if the token has expired
//    private boolean isTokenExpired(String token) {
//        return extractExpiration(token).before(new Date());
//    }
//
//    // Extract the expiration date from the token
//    private Date extractExpiration(String token) {
//        return extractClaim(token, Claims::getExpiration);
//    }
//
    // Get the signing key
    private Key getKey() {
        byte[] keyBytes = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256).getEncoded();
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
