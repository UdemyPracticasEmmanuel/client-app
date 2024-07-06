package com.testing.springboot.client.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((authHttp)->authHttp
                .requestMatchers(HttpMethod.GET,"/authorized").permitAll()
                .requestMatchers(HttpMethod.GET, "/pokemon/*").hasAnyAuthority("SCOPE_read", "SCOPE_write")
                //.requestMatchers(HttpMethod.POST, "/pokemon/create").hasAuthority("SCOPE_write")
                .anyRequest().authenticated())
                .csrf(csrf->csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2Login( login->login.loginPage("/oauth2/authorization/client-app"))
                .oauth2Client(withDefaults())
                .oauth2ResourceServer(resourceServer -> resourceServer.jwt(withDefaults()))
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
        ;

        return http.build();
    }
    /**
     * Configura la fuente de configuración CORS permitiendo orígenes, métodos y
     * cabeceras específicos.
     *
     * @return CorsConfigurationSource configurado con las políticas CORS.
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOriginPatterns(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
        config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
