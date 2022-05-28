package com.project.FoodDeliveryService.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.FoodDeliveryService.Model.Roledata;
import com.project.FoodDeliveryService.Model.UserData;

public class UserDetailsImpl implements UserDetails 	{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	UserData user;

	public UserDetailsImpl(UserData user) {
		this.user = user;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Roledata> authorities = user.getRoles();
		ArrayList<GrantedAuthority> roles=new ArrayList<GrantedAuthority>();

		user.getRoles().forEach(role -> {
			roles.add(new SimpleGrantedAuthority(role.getRolename()));
			System.out.println(authorities);
		});
		return roles;
		
		
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
return	user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
