package jp.co.amedev.amecolle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.amedev.amecolle.constant.AmecolleConst;
import jp.co.amedev.amecolle.repository.UserRepository;
import jp.co.amedev.amecolle.repository.entity.UserEntity;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	
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

	@Transactional
	public UserEntity save(UserEntity account) {
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		account = userRepository.save(account);
		return account;
	}
	
	@Transactional
	public void update(UserEntity input) {
		UserEntity user = userRepository.findOne(input.getId());
		user.setUserId(input.getUserId());
		if(input.getPassword() != null && !input.getPassword().equals("")){
			user.setPassword(passwordEncoder.encode(input.getPassword()));
		}
	}
	
	@Transactional
	public List<UserEntity> findAll() {
		List<UserEntity> userList = userRepository.findAll();
		return userList;
	}
	
	@Transactional
	public void delete(Long id) {
		userRepository.delete(id);
	}
	
	private User createUser(UserEntity account) {
		return new User(account.getUserId(), account.getPassword(), AuthorityUtils.createAuthorityList(account.getRoleId().equals(AmecolleConst.ROLE_ADMIN_NUM) ? AmecolleConst.ROLE_ADMIN : AmecolleConst.ROLE_USER));
	}

}
