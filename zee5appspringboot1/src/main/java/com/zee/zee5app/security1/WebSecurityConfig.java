package com.zee.zee5app.security1;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.zee.zee5app.security.jwt.AuthEntryPointJwt;
import com.zee.zee5app.security.jwt.AuthTokenFilter;
import com.zee.zee5app.security.services.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
//to customize the methods
public class WebSecurityConfig extends WebSecurityConfigurerAdapter 
{
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;
	
	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter()
	{
		return new AuthTokenFilter();
	}
	
	
	
   @Override
protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
	// TODO Auto-generated method stub
	   authenticationManagerBuilder.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
   }
   
   @Bean
   @Override
   public AuthenticationManager authenticationManagerBean() throws Exception
   {
	   return super.authenticationManagerBean();
   }
   
   
   @Bean
   public PasswordEncoder passwordEncoder()
   {
	   return new BCryptPasswordEncoder();
   }
   
   @Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		http.cors().and()
		.csrf()
		.disable()
		.exceptionHandling()
		.authenticationEntryPoint(unauthorizedHandler)
		.and()
		.sessionManagement()
		.and()
		.authorizeHttpRequests().antMatchers("/api/auth/**").permitAll()
		.antMatchers("/api/test/**").permitAll().anyRequest().authenticated();
		
		http.addFilterBefore(authenticationJwtTokenFilter(),UsernamePasswordAuthenticationFilter.class);
		//super.configure(http);
	}
   
   
}
