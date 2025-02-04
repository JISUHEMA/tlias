package com.eden.service;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

import com.eden.dao.UserDao;
import com.eden.entity.User;



@Service
@Transactional
public class UserServiceIMPl  implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void register(User user) {
			
		User userDB=userDao.findByUserName(user.getUsername());
		
		if(!ObjectUtils.isEmpty(userDB)) throw new RuntimeException("このユーザー名は既に存在している");
		
		//将密码加密
		String pwsScrete = DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8));
		
		user.setPassword(pwsScrete);
		
		userDao.save(user);
	}

	@Override
	public User login(String username, String password) {
		
		User user=userDao.findByUserName(username);
		
		if(ObjectUtils.isEmpty(user))throw new RuntimeException("入力たユーザー名が間違っています。");
		
		String digestpwd= DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
		
		if(!user.getPassword().equals(digestpwd)) throw new RuntimeException("入力たパスワードが間違っています。");
		
		return user;
	}

}
