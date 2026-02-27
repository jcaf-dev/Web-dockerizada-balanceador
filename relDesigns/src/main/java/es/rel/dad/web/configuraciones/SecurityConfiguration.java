package es.rel.dad.web.configuraciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;
import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	RepositoryUserDetailsService authenticationProvider;
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10, new SecureRandom());
    }
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// Database authentication provider
		auth.userDetailsService(authenticationProvider).passwordEncoder(passwordEncoder());

	}
	
	
	/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// User
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		String encodePass = encoder.encode("pass");
		auth.inMemoryAuthentication().withUser("user").password(encodePass).roles("USER");
		
	}
	*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		
				// Public pages
				http.authorizeRequests().antMatchers("/").permitAll();
				http.authorizeRequests().antMatchers("/home").permitAll();
				http.authorizeRequests().antMatchers("/contact").permitAll();
				http.authorizeRequests().antMatchers("/artGallery").permitAll();
				http.authorizeRequests().antMatchers("/singin.html").permitAll();
				http.authorizeRequests().antMatchers("/createaccount.html").permitAll();
				http.authorizeRequests().antMatchers("/shoppingCart").permitAll();
				http.authorizeRequests().antMatchers("/shoppingCart/{name}").permitAll();
				http.authorizeRequests().antMatchers("/author/{{nameAuthor}}").permitAll();
				
				http.authorizeRequests().antMatchers("/authorItems").permitAll();
				http.authorizeRequests().antMatchers("/**/*.jpg", "/*.css").permitAll();

				http.authorizeRequests().antMatchers("/login").permitAll();
				http.authorizeRequests().antMatchers("/loginerror").permitAll();

				// Private pages (all other pages)

				http.authorizeRequests().anyRequest().authenticated();

				// Login form
				http.formLogin().loginPage("/login");
				http.formLogin().usernameParameter("username");
				http.formLogin().passwordParameter("password");
				http.formLogin().defaultSuccessUrl("/home2");
				http.formLogin().failureUrl("/loginerror");

				// Logout
				http.logout().logoutUrl("/logout");
				http.logout().logoutSuccessUrl("/");

				// Disable CSRF at the moment
			    //	http.csrf().disable();
		
	}
	
}
