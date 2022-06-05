package com.codecrew.fantasticket.util.security;

import com.codecrew.fantasticket.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {
	private transient User user;
	
	public CustomUserDetails(User user) {
		this.user = user;
	}
	
	public CustomUserDetails() {
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return SecurityUtil.convertToAuthorities(user.getRole().name());
	}
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}
	
	@Override
	public String getUsername() {
		return user.getUsername();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return user.getActive();
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}