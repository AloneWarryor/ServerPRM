package com.fpt.prm.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fpt.prm.mapper.AccountMapper;
import com.fpt.prm.model.Account;

@Service
public class DefaultUserDetailsService implements UserDetailsService {

	@Autowired AccountMapper accountMapper;
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return mockUser(username);
    }

    private UserDetails mockUser(String username) {
    	Account acc = accountMapper.findByUsername(username);
        if (!acc.getUserName().equals(username)) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        // this is another way of dealing with password encoding
        // password will be stored in bcrypt in this example
        // you can also use a prefix, @see com.patternmatch.oauth2blog.config.AuthorizationServerConfig#CLIENT_SECRET
        UserDetails user = User.withDefaultPasswordEncoder()
                .username(acc.getUserName())
                .password(acc.getPassword())
                .authorities(getAuthority(acc))
                .build();

        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(Account acc) {
    	List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
    	for (String autho : acc.getRole().split(",")) {
    		authorities.add(new SimpleGrantedAuthority(autho));
		}
        return authorities;
    }
}