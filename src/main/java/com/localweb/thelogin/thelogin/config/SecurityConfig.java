package com.localweb.thelogin.thelogin.config;

import com.localweb.thelogin.thelogin.dao.UserRepository;
import com.localweb.thelogin.thelogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	/*@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		List<UserDetails> users = new ArrayList<>();
		users.add(User.withDefaultPasswordEncoder().username("admin").password("admin").roles("ADMIN").build());
		return new InMemoryUserDetailsManager(users);
	}*/

	@Bean
	public AuthenticationProvider authenticationProvider(){
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return authenticationProvider;
	}

	/*@Autowired
	private DataSource dataSource;


	public SecurityConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/

	/*@Autowired
        public SecurityConfig(UserService userService) {
            this.userService = userService;
        }

        @Bean
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }*/

        /*@Bean
        public UserDetailsService userDetailsService() {
            return email -> {
				com.localweb.thelogin.thelogin.entities.User user = userService.findUserByEmail(email);
                if (user == null) {
                    throw new UsernameNotFoundException("No user found with this email!");
                }
                return (UserDetails) user;
            };
        }*/


	/*@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
				.withUser(userBuilder.username("admin").password("admin").roles("ADMIN"))
				.withUser(userBuilder.username("operator").password("operator").roles("OPERATOR"));

		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());

		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select email, password, enabled from users where email = ?");

	}*/


	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/").hasAnyRole("ADMIN", "OPERATOR")
				.antMatchers("/users/**").hasAnyRole("ADMIN")
				.antMatchers("/clients/**").hasAnyRole("ADMIN", "OPERATOR")
				.antMatchers("/products/**").hasAnyRole("ADMIN")
				.antMatchers("/orders/**").hasAnyRole("ADMIN", "OPERATOR")
			.and()
				.formLogin().loginPage("/login")
				.loginProcessingUrl("/authenticateTheUser").permitAll()
				//.usernameParameter("email").passwordParameter("password")
			.and()
				.logout().logoutUrl("/logout").logoutSuccessUrl("/logout")
			.and()
				.exceptionHandling().accessDeniedPage("/access-denied");
	}*/

}

