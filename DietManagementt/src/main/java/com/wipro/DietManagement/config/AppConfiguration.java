package com.wipro.DietManagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class AppConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired 
	UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authProvider()
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		System.out.println(provider);
		return provider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http .cors()
	    .and()
		.csrf().disable()
        .authorizeRequests()
        .antMatchers("/login").permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .httpBasic();
		
    	/*http.csrf().disable()
    	.authorizeRequests().antMatchers("/**")
    	.fullyAuthenticated().and().httpBasic();
    	/*.permitAll()
    	.anyRequest().authenticated()
    	.and().httpBasic();
    	.formLogin()
    	.loginPage("/login")
    	.and()
    	.logout().invalidateHttpSession(true)
    	.clearAuthentication(true)
    	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
    	.permitAll();*/
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		web.ignoring().antMatchers("/h2-console/**");
	}
	
	
	
	

}
