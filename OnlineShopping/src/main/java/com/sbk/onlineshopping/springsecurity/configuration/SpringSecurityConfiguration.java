package com.sbk.onlineshopping.springsecurity.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {

	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("select email,password,true from user_detail where email=?")
			.authoritiesByUsernameQuery("select email,role from user_detail where email=?");
		
        /*auth.inMemoryAuthentication().withUser("bhayyasahebkoke@gmail.com").password("SBK@123").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("sbk@gmail.com").password("123456").roles("USER");*/
        
    }
	protected void configure(HttpSecurity http) throws Exception {
       
      http.authorizeRequests()
      	
      	.antMatchers("/manage/**").access("hasRole('ADMIN')")
      	
      	.and()
      		.formLogin().loginPage("/login").failureUrl("/loginError")
      		.usernameParameter("email").passwordParameter("password")
      	
      	.and()
      		.logout().logoutSuccessUrl("/logout")
      	
      		.and()
      			.exceptionHandling().accessDeniedPage("/accessDenied");
      			
      		/*.and()
      			.csrf().ignoringAntMatchers("/manage/**");*/
       /* .antMatchers("/", "/home","/login").permitAll()
        .antMatchers("/manage/**").access("hasRole('ADMIN')")
        .and().formLogin();*/
    }
	
	
}
