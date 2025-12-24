// package com.springsecurity.learningspringsecurity.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//         http
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers("/home").permitAll()
//                 .requestMatchers("/admin/**").permitAll()
//                 .requestMatchers("/user/**").permitAll()
//                 .anyRequest().authenticated()
//             )
//             .formLogin(form -> form
//                 .defaultSuccessUrl("/home", true)
//             )
//             .logout(logout -> logout
//                 .logoutSuccessUrl("/home")
//             );

//         return http.build();
//     }
// }
