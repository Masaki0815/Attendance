package com.example.AttendanceManage.Config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(login -> login
                .loginPage("/user/login")
                .loginProcessingUrl("/user/login")
                .usernameParameter("username")  // デフォルトのため実際には記述不要
                .passwordParameter("password")  // デフォルトのため実際には記述不要
                .defaultSuccessUrl("/user/list")
                .failureUrl("/user/login?error")
                .permitAll()
        ).logout(logout -> logout
                .logoutUrl("/user/logout")
                .logoutSuccessUrl("/user/login")
        ).authorizeHttpRequests(authz -> authz
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .requestMatchers("/user/login").permitAll()
                //.requestMatchers("/user/regist").permitAll()
                .anyRequest().authenticated()
        );
        return http.build();
    }
}