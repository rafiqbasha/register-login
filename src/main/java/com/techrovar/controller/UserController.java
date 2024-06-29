package com.techrovar.controller;

import com.techrovar.dto.LoginDTO;
import com.techrovar.dto.UserDTO;
import com.techrovar.paylodresponse.LogInMessage;
import com.techrovar.paylodresponse.LogInResponse;
import com.techrovar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/save")
    public String saveUser(@RequestBody UserDTO userDTO){
        String id = userService.addUser(userDTO);
        return id;
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){
        LogInResponse logInResponse = userService.logInUser(loginDTO);
        return ResponseEntity.ok(logInResponse);
    }
}
