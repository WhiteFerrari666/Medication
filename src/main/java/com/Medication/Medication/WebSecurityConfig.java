package com.Medication.Medication;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Diese Klasse macht noch nichts und war nur zum Experimentieren mit
 * UserCredentials da. Ich lasse sie mal drin, falls wir sie noch brauchen.
 * Braucht ansonsten keine Beachtung.
 *
 * @author mde
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
/*
	 *
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
	 * throws Exception { auth.inMemoryAuthentication()
	 * .withUser("user").password("password").roles("USER") .and()
	 * .withUser("admin").password("password").roles("USER", "ADMIN"); }
	 * 
	 * @Bean public UserDetailsService userDetailsService() { User.UserBuilder users
	 * = User.withDefaultPasswordEncoder(); InMemoryUserDetailsManager manager = new
	 * InMemoryUserDetailsManager();
	 * manager.createUser(users.username("user").password("password").roles("USER").
	 * build());
	 * manager.createUser(users.username("admin").password("password").roles("ADMIN"
	 * ).build()); return manager; }
	 * 
	 * protected void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests() .antMatchers("/", "/home").access("hasRole('USER')")
	 * .antMatchers("/admin/**").hasRole("ADMIN")
	 * .and().httpBasic().and().formLogin().loginPage("/login").permitAll(); }
	 * 
*/

}
