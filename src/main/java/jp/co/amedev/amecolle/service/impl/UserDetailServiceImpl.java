package jp.co.amedev.amecolle.service.impl;

import java.util.Date;
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
			UserEntity user = userRepository.findOneByUserId(userId);
			if (user == null) {
				throw new UsernameNotFoundException("user not found");
			}
			this.login(user);
			return createUser(user);
		} catch (UsernameNotFoundException e){
			throw new UsernameNotFoundException("user not found");
		} catch (JpaSystemException e) {
			throw new AuthenticationServiceException("Database Connection not fournd");
		}
	}

	@Transactional
	public UserEntity save(UserEntity user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setUpdateTime(new Date());;
		user.setDeleteFlag(AmecolleConst.DELETE_FLAG_OFF);
		user = userRepository.save(user);
		return user;
	}
	
	@Transactional
	public void update(UserEntity input) {
		UserEntity user = userRepository.findOne(input.getId());
		user.setUserId(input.getUserId());
		if(input.getPassword() != null && !input.getPassword().equals("")){
			user.setPassword(passwordEncoder.encode(input.getPassword()));
		}
		user.setUpdateTime(new Date());
	}
	
	@Transactional
	public void login(UserEntity input) {
		UserEntity user = userRepository.findOne(input.getId());
		user.setLatestLoginTime(new Date());
		userRepository.save(user);
	}
	
	@Transactional
	public List<UserEntity> findAll() {
		List<UserEntity> userList = userRepository.findByDeleteFlag(AmecolleConst.DELETE_FLAG_OFF);
		return userList;
	}
	
	@Transactional
	public void delete(Long id) {
		UserEntity user = userRepository.findOne(id);
		user.setDeleteFlag(AmecolleConst.DELETE_FLAG_ON);
		user.setUpdateTime(new Date());
	}
	
	private User createUser(UserEntity account) {
		return new User(account.getUserId(), account.getPassword(), AuthorityUtils.createAuthorityList(account.getRoleId().equals(AmecolleConst.ROLE_ADMIN_NUM) ? AmecolleConst.ROLE_ADMIN : AmecolleConst.ROLE_USER));
	}

}
