package com.zosh.controller;


import com.zosh.model.User;
import com.zosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/users")
@RestController
public class UserController {
   @Autowired
    private UserService userService;
@GetMapping("/profile")
   public ResponseEntity<User>findUserByJwtToken(@RequestHeader("Authorization")String jwt) throws Exception {
     User user = userService.findUserByJwtToken(jwt);
     return new ResponseEntity<>(user, HttpStatus.OK);
   }

}
