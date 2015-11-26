package com.lightningcd.api.rest;


import com.lightningcd.api.exception.UserAlreadyExistException;
import com.lightningcd.api.exception.UserNotFoundException;
import com.lightningcd.api.model.Authentication;
import com.lightningcd.api.service.AuthenticationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(value = "AuthenticationApi", description = "API for lcd authentication")
public class AuthenticationController {

    private AuthenticationService authenticationService;
    private static final String JSON = MediaType.APPLICATION_JSON_VALUE;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "/authenticateUser", method = RequestMethod.POST, consumes = JSON, produces = JSON)
    @ApiOperation(value = "AuthenticateUser", nickname = "Authenticate", response = String.class)
    public ResponseEntity<String> authenticateUser(@Valid @RequestBody Authentication request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(authenticationService.authenticateUser(request.getUsername(), request.getPassword()));
        } catch (UserNotFoundException ue) {
            return ResponseEntity.status(HttpStatus.OK).body("User does not exist");
        }
    }


    @RequestMapping(value = "/getUser", method = RequestMethod.GET, consumes = JSON, produces = JSON)
    @ApiOperation(value = "Get User", nickname = "GetUser", response = Authentication.class)
    public ResponseEntity<Authentication> getUser(@Valid @RequestBody String userName) {
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.get(userName));
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST, consumes = JSON, produces = JSON)
    @ApiOperation(value = "Create User", nickname = "CreateUser", response = String.class)
    public ResponseEntity<String> createUser(@Valid @RequestBody Authentication request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(authenticationService.create(request.getUsername(), request.getPassword()));
        } catch (UserAlreadyExistException ue) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exist");
        }
    }


    @RequestMapping(value = "/updateUser", method = RequestMethod.POST, consumes = JSON, produces = JSON)
    @ApiOperation(value = "Update User", nickname = "UpdateUser", response = String.class)
    public ResponseEntity<String> updateUser(@Valid @RequestBody Authentication request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(authenticationService.update(request.getUsername(), request.getPassword()));
        } catch (UserNotFoundException ue) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User does not exist");
        }
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET, consumes = JSON)
    @ApiOperation(value = "Delete User", nickname = "DeleteUser", response = String.class)
    public ResponseEntity<String> deleteUser(@Valid @RequestBody String userName) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(authenticationService.delete(userName));
        } catch (UserNotFoundException ue) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User does not exist");
        }
    }

}
