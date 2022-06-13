package com.codecrew.fantasticket.config;


import com.codecrew.fantasticket.filter.JwtAuthFilter;
import com.codecrew.fantasticket.util.security.CustomUserDetailsService;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors();
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests()
				.antMatchers(HttpMethod.PUT, "/api/**").permitAll()
				.anyRequest().permitAll();
//		http.authorizeRequests()
//				.antMatchers("/api/authentication/**").permitAll()
//				.antMatchers(HttpMethod.POST, "/api/authentication/**").permitAll()
//				.antMatchers("/swagger-ui/**", "/api/user/forgot-password").permitAll()
//				.antMatchers(HttpMethod.GET, "/api/project-settings/**").permitAll()
//				.antMatchers(HttpMethod.POST, "/api/project-settings/**").hasAuthority("Role_ADMIN")
//				.antMatchers(HttpMethod.PUT, "/api/project-settings/**").hasAuthority("Role_ADMIN")
//				.antMatchers("/api/user/change-role/**", "/api/scooter/**").hasAuthority("Role_ADMIN")
//				.antMatchers("/api/**").hasAnyAuthority("Role_ADMIN", "Role_USER", "Role_EMPLOYEE")
//				.anyRequest().permitAll();
		
		http.addFilterBefore(jwtAuthFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean
	public JwtAuthFilter jwtAuthFilter(){
		return new JwtAuthFilter();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Bean
	public WebMvcConfigurer configurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedHeaders("*");
			}
		};
	}
	
	@Bean
	public OpenAPI myAPI() {
		return new OpenAPI()
				.components(new Components()
						.addSecuritySchemes("bearer-key",
								new SecurityScheme()
										.type(SecurityScheme.Type.HTTP)
										.scheme("bearer")
										.bearerFormat("JWT")
						)
				)
				.info(new Info()
						.title("Fantastic Ticket REST API")
						.description("Documentation of API v.1.0")
						.version("1.0")
				).addSecurityItem(
						new SecurityRequirement()
								.addList("bearer-jwt", Arrays.asList("read", "write"))
								.addList("bearer-key", Collections.emptyList())
				);
	}
	
}