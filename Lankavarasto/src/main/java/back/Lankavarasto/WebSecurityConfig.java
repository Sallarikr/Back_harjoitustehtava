package back.Lankavarasto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import back.Lankavarasto.web.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

	@Autowired
	private UserDetailServiceImpl userDetailsService;

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**").permitAll().and().authorizeRequests().anyRequest()
				.authenticated().and().formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/", true).and()
				.logout().logoutSuccessUrl("/login").permitAll();

		return http.build();
	};

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}