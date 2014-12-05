package com.example.hcsweb.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hcsweb.dao.UserDao;
import com.example.hcsweb.model.users.UserType;

@Service("userDetailsService")
@Transactional
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.example.hcsweb.model.users.User user = userDao.getUserByUsername(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserType());

		return this.buildUserForAuthentication(user, authorities);
	}

	/**
	 * get an entity of Spring security.core.userdetails.User
	 * 
	 * @param user
	 * @param authorities
	 * @return
	 */
	private User buildUserForAuthentication(com.example.hcsweb.model.users.User user, List<GrantedAuthority> authorities) {
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		return new User(user.getUsername(), user.getPassword(), user.getEnabled(), accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
	}

	/**
	 * Build user authority from given UserType
	 * 
	 * @param userType
	 * @return
	 */
	private List<GrantedAuthority> buildUserAuthority(UserType type) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		// Build user's authorities
		setAuths.add(new SimpleGrantedAuthority(type.getUserType()));

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}
}
