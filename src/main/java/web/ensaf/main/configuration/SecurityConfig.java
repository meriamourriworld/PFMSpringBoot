package web.ensaf.main.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		return http.formLogin(Customizer.withDefaults())
				.authorizeHttpRequests(req -> req
				.requestMatchers("/login/**").permitAll()
				.requestMatchers("/").permitAll()
				.requestMatchers("/user/**").hasAnyAuthority("ADMIN")
				.requestMatchers("/img/**").permitAll() 
				.requestMatchers("/css/**").permitAll() 
				.anyRequest().authenticated())
				.userDetailsService(userDetailsService)
				.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	

	
}
