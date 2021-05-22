package com.arifulhaque.springsecuritylearning.security;

import com.arifulhaque.springsecuritylearning.security.user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Enable basic authentication
        // any requests must be authenticated using basic authentication
        http
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*", "/dist/*", "/admin/dist/*")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }


    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        // create users
        UserDetails userAriful = User.builder()
                .username("arifulhb")
                .password(passwordEncoder.encode("password"))
                .roles(UserRole.STUDENT.name()) // ROLE_STUDENT
                .build();

        UserDetails tajia = User.builder()
                .username("tajia")
                .password(passwordEncoder.encode("password"))
                .roles(UserRole.ADMIN.name())
                .build();

        return new InMemoryUserDetailsManager(
                userAriful,
                tajia

        );
    }
}
