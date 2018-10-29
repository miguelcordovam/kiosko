package com.products.meli;

import com.products.meli.filter.CsrfHeaderFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@SpringBootApplication
@EnableOAuth2Sso
@Configuration
@EnableWebSecurity
public class MeliApplication extends WebSecurityConfigurerAdapter{

    @Autowired
    CustomSuccessHandler successHandler;

	public static void main(String[] args) {
		SpringApplication.run(MeliApplication.class, args);
	}

    @Override
    protected void configure(HttpSecurity http) throws Exception {

	    http
                .cors()
                .and()
                    .csrf().csrfTokenRepository(csrfTokenRepository())
                .and()
                    .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
                    .antMatcher("/**").authorizeRequests()
                    .antMatchers("/logout", "/login", "/error**").permitAll()
                    .anyRequest().authenticated()
                ;
    }

    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;
    }

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

    @Bean
    CorsConfigurationSource corsConfigurationSource()
    {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","OPTIONS"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
