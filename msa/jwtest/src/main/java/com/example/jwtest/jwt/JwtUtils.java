package com.example.jwtest.jwt;

import com.example.jwtest.Entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;


@Component
public class JwtUtils {
    private static final String SECRET_KEY = "VGhpcyBpcyBhIHNlY3JldCBrZXkgZm9yIEpXVCBzaWduYXR1cmUgaW4gQjY0";
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; //1시간

    // 1. JWT 토큰 생성
    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)                // 사용자 식별자 설정
                .setIssuedAt(new Date())            // 토큰 발행 시간
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))  // 만료 시간
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)  // 서명 알고리즘과 키 설정
                .compact();
    }

    // 2. 토큰에서 사용자 이름 추출
    public String getUsernameFromToken(String token){
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // 3. 토큰 만료 여부 확인
    public boolean isTokenExpired(String token){
        return getExpirationDateFromToken(token).before(new Date());
    }

    // 4. 토큰에서 만료 시간 추출
    private Date getExpirationDateFromToken(String token){
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
    }

    // 5. 토큰 유효성 검증
    public boolean validateToken(String token, String username){
        return (username.equals(getUsernameFromToken(token)) && !isTokenExpired(token));
    }
}