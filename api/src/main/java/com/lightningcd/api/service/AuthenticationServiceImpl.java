package com.lightningcd.api.service;


import com.lightningcd.api.exception.UserAlreadyExistException;
import com.lightningcd.api.exception.UserNotFoundException;
import com.lightningcd.api.model.Authentication;
import com.lightningcd.api.repository.AuthenticationRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthenticationServiceImpl implements AuthenticationService {

    private AuthenticationRepository authenticationRepository;

    @Autowired
    public AuthenticationServiceImpl(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    @Override
    public Iterable<Authentication> all() {
        return authenticationRepository.findAll();
    }

    @Override
    public Authentication get(ObjectId id) {
        return authenticationRepository.findOne(id);
    }

    @Override
    public Authentication get(String username) {
        return authenticationRepository.findByUserName(username);
    }

    @Override
    public String create(String userName, String password) throws UserAlreadyExistException {
        Authentication authentication = new Authentication(userName, password);
        authenticationRepository.save(authentication);
        return authentication.getUsername();
    }

    @Override
    public String update(String userName, String password) throws UserNotFoundException {
        Authentication authentication = authenticationRepository.findByUserName(userName);
        authentication.setPassword(password);
        authentication.setUsername(userName);
        authenticationRepository.save(authentication);
        return authentication.getUsername();
    }

    @Override
    public String delete(String userName) throws UserNotFoundException {
        Authentication authentication = authenticationRepository.findByUserName(userName);
        authenticationRepository.delete(authentication);
        return authentication.getUsername();
    }

    @Override
    public String authenticateUser(String username, String password) throws UserNotFoundException {
        Authentication authentication = authenticationRepository.findByUserName(username);
        if (authentication.getPassword().equals(password)) {
            return "successful";
        } else {
            return "unsuccessful";
        }
    }
}
