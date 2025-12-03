package org.example.java6_thuchanh.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SpringSecurityCofig {

//    quan ly detail cua user (username, password, email,...)
    private final UserDetailsService userDetailsService;

    // ma hoa pass
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // be khoa, cho phep CRUD
        http.csrf(csrsConfigurer -> csrsConfigurer.disable())
                .authorizeHttpRequests(authorrize -> {
                    authorrize.requestMatchers(HttpMethod.POST, "/api/todos/**").hasRole("ADMIN"); // them - admin
                    authorrize.requestMatchers(HttpMethod.PUT, "/api/todos/**").hasRole("ADMIN"); // sua - admin
                    authorrize.requestMatchers(HttpMethod.DELETE, "/api/todos/**").hasRole("ADMIN"); // xoa - admin


                    authorrize.requestMatchers(HttpMethod.GET, "/api/todos/**").hasAnyRole("ADMIN", "USER"); // get all
//
//                    // for coding, testing
//                    authorrize.requestMatchers(HttpMethod.GET, "api/books").permitAll(); // khong phan quyen

                    authorrize.anyRequest().authenticated();
                })
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
//        return configuration.getAuthenticationManager();
//    }


//    In Memory
    @Bean
    public UserDetailsService userDetailsService() {
        // custom user
        UserDetails customUser = User.builder()
                .username("user")
                .password(passwordEncoder().encode("123456"))
                .roles("USER")
                .build();

        UserDetails customAdmin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("123456"))
                .roles("ADMIN", "USER")
                .build();

        return new InMemoryUserDetailsManager(customUser, customAdmin);
    }
}

