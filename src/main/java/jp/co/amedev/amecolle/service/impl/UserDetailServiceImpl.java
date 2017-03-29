package jp.co.amedev.amecolle.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.amedev.amecolle.repository.UserRepository;
import jp.co.amedev.amecolle.repository.entity.UserEntity;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	private Collection<GrantedAuthority> getAuthorities(UserEntity user) {
		// if(user.isAdmin()){
		return AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
		// }else{
		// return AuthorityUtils.createAuthorityList("ROLE_USER");
		// }
	}

	@Transactional
	public UserEntity save(UserEntity account) {
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		userRepository.save(account);
		return account;
	}

	@Override
	public User loadUserByUsername(String userId) throws UsernameNotFoundException {
		try {
			UserEntity account = userRepository.findOneByUserId(userId);
			if (account == null) {
				throw new UsernameNotFoundException("user not found");
			}
			return createUser(account);
		} catch (UsernameNotFoundException e){
			throw new UsernameNotFoundException("user not found");
		} catch (JpaSystemException e) {
			throw new AuthenticationServiceException("Database Connection not fournd");
		}
	}

	private User createUser(UserEntity account) {
		return new User(account.getUserId(), account.getPassword(), getAuthorities(account));
	}

}
