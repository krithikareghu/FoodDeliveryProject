package com.project.FoodDeliveryService.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import com.project.FoodDeliveryService.Service.CustomUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class FoodAppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	JwtEntryPoint entryPoint;
	@Autowired
	JwtRequestFilter jwtRequestFilter;
	@Autowired
	private CustomUserDetailService customUserDetailService; 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder()); //spring userdetailsservice  
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
    @Override
    @Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
    @Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
 
    	httpSecurity.cors().disable();
    	httpSecurity.csrf().disable()
		.authorizeRequests().antMatchers("/authenticate", "/register")
		.permitAll().antMatchers(HttpMethod.OPTIONS,"/**")
		.permitAll(). anyRequest().authenticated()
		.and(). exceptionHandling().authenticationEntryPoint(entryPoint)
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
}









	////		
////		@Autowired
////		DataSource dataSource;
////		
////		auth.jdbcAuthentication()
////		.dataSource(dataSource);
////	}
//
////	@Bean
////    public BCryptPasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//		daoAuthenticationProvider.setUserDetailsService(customUserDetailService);
//		daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
//		return daoAuthenticationProvider;
//	}
//
////
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////
////		http
////		.csrf()
////		.disable()
////		.authorizeRequests().antMatchers("/**").permitAll()
//////		.anyRequest().authenticated()
//////		.and()
//////		.formLogin()
//////		.loginPage("/login")
//////		.permitAll()
////		.and()
////		.logout()
////		.invalidateHttpSession(true)
////		.clearAuthentication(true)
////		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
////		.logoutSuccessUrl("/logout-success").permitAll();
////
////	}
	
//				.and().
//				exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Add a filter to validate the tokens with every request
	//	httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//	}
////
////
//@EnableGlobalMethodSecurity(
//		 //securedEnabled = true,
////		 jsr250Enabled = true,
////		prePostEnabled = true)
//public class FoodAppSecurityConfig extends WebSecurityConfigurerAdapter {
//	@Autowired
//	CustomUserDetailService userDetailsService;
//	@Autowired
//	private JwtEntryPoint unauthorizedHandler;
//	@Bean
//	public AuthTokenFilter authenticationJwtTokenFilter() {
//		return new AuthTokenFilter();
//	}
//	@Override
//	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//	}
//	@Bean
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.cors().and().csrf().disable()
//			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//			.authorizeRequests().antMatchers("/api/auth/**").permitAll()
//			.antMatchers("/api/test/**").permitAll()
//			.anyRequest().authenticated();
//		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//	}
//}