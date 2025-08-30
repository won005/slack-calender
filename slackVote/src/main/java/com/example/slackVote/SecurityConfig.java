package com.example.slackVote;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/slack/events") // '/slack/events' 경로의 POST 요청에는 CSRF 보호를 적용하지 않음
                );

        // 여기에 다른 시큐리티 설정을 추가할 수 있습니다.
        // http.authorizeHttpRequests(...)

        return http.build();
    }
}