package com.capgemini.training.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.training.dao.LoginRepository;
import com.capgemini.training.entity.UserEntity;

@Service
public class LoginServices {

	@Autowired
	LoginRepository repository;
	
	public UserEntity registerUser(UserEntity userEntity) {
		return repository.save(userEntity);
	}
	
	public boolean validateUser(String user, String password) {

        UserEntity userEntity = repository.findByUserAndPassword(user, password);

        if(userEntity != null) {
            return true;
        }

        return false;
    }
}
