package com.example.demosecurityamigoscode.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Enable and configure everything that has to do with security in the application.
 */
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic(); //there is no way to logout as username and password are validated in every request
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails annaSmithUser = User.builder()
                .username("annasmith")
                .password("password")
                .roles("STUDENT") //ROLE_STUDENT -> ROLE_ prefix automatically added since spring security 4.
                .build();

        return new InMemoryUserDetailsManager(
                annaSmithUser
        );
    }
}
