package com.kayode.restaurantservice.security.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.function.Supplier;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

       return httpSecurity.httpBasic().and().csrf().disable().authorizeHttpRequests().anyRequest().permitAll().and().build();
    }

    @Bean
    UserDetailsService userDetailsService(){

        return new InMemoryUserDetailsManager();
    }

    @Bean
    PasswordEncoder passwordEncoder(){

        return NoOpPasswordEncoder.getInstance();
    }

//   private AuthenticationTrustResolver authenticationTrustResolver(){
//
//        return new AuthenticationTrustResolver() {
//            @Override
//            public boolean isAnonymous(Authentication authentication) {
//                return false;
//            }
//
//            @Override
//            public boolean isRememberMe(Authentication authentication) {
//                return false;
//            }
//        };
//    }
//
//
//    private AuthorizationFilter authorizationFilter(){
//        AuthenticatedAuthorizationManager<HttpServletRequest> authorizationManager= new AuthenticatedAuthorizationManager<>();
//
//        authorizationManager.setTrustResolver(authenticationTrustResolver());
//
//        AuthorizationFilter authorizationFilter= new AuthorizationFilter(authorizationManager);
//
//        return authorizationFilter;
//
//    }


}
