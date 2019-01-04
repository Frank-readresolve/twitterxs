package fr.formation.twitterxs;

import org.modelmapper.ModelMapper;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
    }

    @Bean
    protected LocalValidatorFactoryBean validator(MessageSource messageSource) {
	LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
	validatorFactoryBean.setValidationMessageSource(messageSource);
	return validatorFactoryBean;
    }

    /**
     * Dafault {@code ModelMapper} in order to ease mapping from DTO to
     * entities, and from entities to DTOs.
     *
     * @return an instance of {@code ModelMapper}
     */
    @Bean
    public ModelMapper mapper() {
	// Could be configured changing default configuration
	return new ModelMapper();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
    }

    @EnableWebSecurity
    @EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
    protected static class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
		throws Exception {
	    auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    // CSRF disabled to ease tests with Postman
	    http.csrf().disable().authorizeRequests()
		    .antMatchers("/login", "/security/authError",
			    "/security/login", "/security/logout",
			    "/users/create", "/mvc/**")
		    // "/mvc/**" for JSP examples
		    .permitAll().and().formLogin().loginPage("/security/login")
		    .loginProcessingUrl("/login")
		    .defaultSuccessUrl("/security/me", true)
		    .failureUrl("/security/authError").and().logout()
		    .invalidateHttpSession(true)
		    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		    .logoutSuccessUrl("/security/logout").and()
		    .authorizeRequests().anyRequest().authenticated().and()
		    .authorizeRequests().antMatchers("/actuator/**")
		    .hasRole("ACTUATOR"); // or .hasAuthority("ROLE_ACTUATOR")
	}
    }

    @Component
    public static class AppStartupRunner implements ApplicationRunner {

	private static final Logger LOGGER = LoggerFactory
		.getLogger(AppStartupRunner.class);

	@SuppressWarnings("unused")
	@Override
	public void run(ApplicationArguments args) {
	    // Do something on application starts up
	    LOGGER.info("Twitterxs application started! Thanks Spring boot.");
	}
    }
}
