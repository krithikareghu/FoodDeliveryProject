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
		auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder()); // spring
																								// userdetailsservice
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
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
		.authorizeRequests().antMatchers("/authenticate","/allitems","/allcategories","/categorypic","/register","/getitembyid/{itemname}","/addtocart","/deleterestaurant/{name}",
				"/findAllcategories","/allcategory","/getitem","/addrestaurant","/getuserdetails","/allrestaurants","/checkout_order","/allusers","/getOrdersByUserId",
				"/addrestaurantstocategory/{categoryid}/{restaurantid}","/getrestaurantsfromcategory/{categoryid}","/findcategorydetails/{categoryid}",
				"{restaurantname}/iteminrestaurant/{itemid}","/getuserdetails/{phonenumber}","/getcartitems","/additemtocart","/getCartsByUserId","/deleteuser/{id}",
				"/additemstorestaurant/{itemid}/{restaurantid}","/getitemsfromrestaurants/{restaurantname}","/itempic/{restaurantname}","/addrestaurant","/loginrestaurant")
		.permitAll().antMatchers(HttpMethod.OPTIONS,"/**")
		.permitAll(). anyRequest().authenticated()
		.and(). exceptionHandling().authenticationEntryPoint(entryPoint)
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//            http.csrf().disable().cors().and().authorizeRequests()
//                    .antMatchers("/register").permitAll()
//                    .antMatchers("/authenticate").permitAll()
//                    .antMatchers("/booking/**", "/bus/**").hasAnyAuthority("user", "Admin")
//                    .antMatchers("/user/**").hasAnyAuthority("user")
//                    .antMatchers("/Admin/**").hasAnyAuthority("Admin")
//                    .anyRequest().authenticated().and()
//                    .exceptionHandling().and().sessionManagement()
//                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//    }

//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//
//		httpSecurity.cors().disable();
//		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/register","/deleteitems/{id}","/deleteuser/{id}","/deleterestaurant/{id}",
//				"/admin/deleterestaurant/{id}").permitAll()
//				.antMatchers("/authenticate").permitAll().antMatchers("/users/**").hasAuthority("ROLE_user")
//				.antMatchers("/admin/**").hasAuthority("ROLE_Admin")
//		 .anyRequest().authenticated().and().exceptionHandling().authenticationEntryPoint(entryPoint).and()
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//	}
}
