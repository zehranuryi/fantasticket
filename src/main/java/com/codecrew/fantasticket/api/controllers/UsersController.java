package com.codecrew.fantasticket.api.controllers;

import com.codecrew.fantasticket.business.abstracts.UserService;
import com.codecrew.fantasticket.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/api/users")
public class UsersController {
    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        super();
        this.userService = userService;
    }

    @PostMapping(value="/add")
    public ResponseEntity<?> add(@Valid @RequestBody User user) {

        return ResponseEntity.ok(this.userService.add(user)) ;
    }
}
