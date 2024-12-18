package com.example.jwtest.Config;



import com.example.jwtest.jwt.JwtAuthenticationFilter;
import com.example.jwtest.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.Arrays;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration  // 스프링 설정 클래스임을 나타냄
@EnableWebSecurity  // 스프링 시큐리티 활성화
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtUtils jwtUtils;  // JWT 관련 유틸리티 클래스 주입

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // BCryptPasswordEncoder 빈 등록
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // CSRF 보호 기능 비활성화 (JWT를 사용하므로 불필요)
            .csrf(csrf -> csrf.disable())
            
            // 기본 폼 로그인 비활성화 (JWT 사용)
            .formLogin(form -> form.disable())
            
            // HTTP Basic 인증 비활성화
            .httpBasic(basic -> basic.disable())
            
            // 세션 관리 설정
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))  // 세션을 생성하지 않음
            
            // URL 별 접근 권한 설정
            .authorizeHttpRequests(

                    auth -> auth
                // swagger와 인증 관련 경로는 모든 사용자에게 허용
//                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/auth/**").permitAll()
                // 그 외 모든 요청은 인증 필요
//                .anyRequest().authenticated()

                    .anyRequest().permitAll() //모든 사용자 허용
            )
//     아직 적용x           .antMatchers("/login", "/error").permitAll()  // 로그인 페이지 등 허용
            
            // JWT 인증 필터 추가
            .addFilterBefore(new JwtAuthenticationFilter(jwtUtils), 
                           UsernamePasswordAuthenticationFilter.class)
            
            // 로그아웃 설정
            .logout(logout -> logout
                .logoutUrl("/auth/logout")  // 로그아웃 URL
                .clearAuthentication(true)  // 인증 정보 제거
                .invalidateHttpSession(true) // 세션 무효화
                .permitAll()
            )
            
            // 보안 헤더 설정
            .headers(headers -> headers
                .frameOptions(frame -> frame.deny())  // clickjacking 방지
                .xssProtection(xss -> xss.disable())  // 내장 XSS 보호 사용
                .contentSecurityPolicy(csp -> 
                    csp.policyDirectives("default-src 'self'"))  // CSP 설정
            )
            
            // CORS 설정 적용
            .cors(cors -> cors
                .configurationSource(corsConfigurationSource())
            );

        return http.build();
    }

    // CORS 설정을 위한 Bean
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        
        // 허용할 출처 설정
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000")); 
        
        // 허용할 HTTP 메서드 설정
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        
        // 허용할 헤더 설정
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        
        // 노출할 헤더 설정
        configuration.setExposedHeaders(Arrays.asList("Authorization"));
        
        // 모든 경로에 대해 CORS 설정 적용
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        
        return source;
    }
}