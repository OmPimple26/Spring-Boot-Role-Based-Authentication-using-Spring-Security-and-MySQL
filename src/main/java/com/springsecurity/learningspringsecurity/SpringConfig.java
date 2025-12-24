package com.springsecurity.learningspringsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.springsecurity.learningspringsecurity.model.MyUserDetailService;

@Configuration
public class SpringConfig {

    @Autowired
    private MyUserDetailService myUserDetailService;    

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//     @Bean
//     public UserDetailsService userDetailsService() {
//         // Implementation details would go here

//         UserDetails admin = User.builder()
//                 .username("om")
//                 .password(passwordEncoder().encode("1234"))
//                 .roles("ADMIN")
//                 .build();

//         UserDetails user = User.builder()
//                 .username("anushka")
//                 .password(passwordEncoder().encode("5678"))
//                 .roles("USER")
//                 .build();

//         return new InMemoryUserDetailsManager(admin, user);
//     }

    // @Bean
    // public UserDetailsService userDetailsService() {
    //     return myUserDetailService;
    // }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        // Implementation details would go here
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(myUserDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        // Security filter chain configuration would go here
        return security
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/home", "/register/user").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/user/**").hasRole("USER")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        // .loginPage("/login")
                        .loginPage("/login")
                        .successHandler(new SuccessHandler())
                        .permitAll()
                )
                .logout(logout -> logout.permitAll())
                .build();
                
    }
}
