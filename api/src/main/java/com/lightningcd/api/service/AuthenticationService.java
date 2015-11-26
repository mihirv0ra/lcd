package com.lightningcd.api.service;


import com.lightningcd.api.exception.UserAlreadyExistException;
import com.lightningcd.api.exception.UserNotFoundException;
import com.lightningcd.api.model.Authentication;
import org.bson.types.ObjectId;

public interface AuthenticationService {

    Iterable<Authentication> all();

    Authentication get(ObjectId id);

    Authentication get(String username);

    String create(String userName, String password) throws UserAlreadyExistException;

    String update(String userName, String password) throws UserNotFoundException;

    String delete(String username) throws UserNotFoundException;

    String authenticateUser(String username, String password) throws UserNotFoundException;

}
