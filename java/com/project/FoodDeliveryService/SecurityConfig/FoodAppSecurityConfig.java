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
		.authorizeRequests().antMatchers("/authenticate","/allitems","/allcategories","/categorypic","/register","/getitembyid/{itemname}","/addtocart",
				"/findAllcategories","/allcategory","/getitem","/addrestaurant","/getuserdetails","/allrestaurants","/checkout_order","/allusers","/getOrdersByUserId",
				"/addrestaurantstocategory/{categoryid}/{restaurantid}","/getrestaurantsfromcategory/{categoryid}","/findcategorydetails/{categoryid}",
				"{restaurantname}/iteminrestaurant/{itemid}","/getuserdetails/{phonenumber}","/getcartitems","/additemtocart","/getCartsByUserId",
				"/additemstorestaurant/{itemid}/{restaurantid}","/getitemsfromrestaurants/{restaurantname}","/itempic/{restaurantname}","/addrestaurant")
		.permitAll().antMatchers(HttpMethod.OPTIONS,"/**")
		.permitAll(). anyRequest().authenticated()
		.and(). exceptionHandling().authenticationEntryPoint(entryPoint)
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
}









	