/*package com.crosspay.rates.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.inMemoryAuthentication() .withUser("anand")
	 * .password("anand") .roles("USER"); }
	 
	@Autowired
	DataSource datasource;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(datasource)
		.withDefaultSchema()
		.withUser(
				User.withUsername("anand")
				.password("anand")
				.roles("USER")
				)
		.withUser(
				User.withUsername("anandAdmin")
				.password("anand")
				.roles("ADMIN")
				);
		
 	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
			.antMatchers("/**")
			.hasAnyRole("ADMIN")
			.and()
			.formLogin();
	}

	@Bean
	public PasswordEncoder getPassword() {
			return NoOpPasswordEncoder.getInstance();
	}

}
*/