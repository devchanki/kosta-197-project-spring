package org.aptogether.service;

import org.aptogether.domain.CustomUser;
import org.aptogether.domain.MemberVO;
import org.aptogether.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService{
	
	@Setter(onMethod_ = {@Autowired})
	private MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn("userName" + username);
		MemberVO member = memberMapper.memberInfo(username);
		
		log.warn("this is " + member);
		return member == null ? null : new CustomUser(member);
	}
	
}
