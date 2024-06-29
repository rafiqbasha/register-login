package com.techrovar.service;

import com.techrovar.dto.LoginDTO;
import com.techrovar.dto.UserDTO;
import com.techrovar.paylodresponse.LogInMessage;
import com.techrovar.paylodresponse.LogInResponse;
import org.springframework.stereotype.Service;


public interface UserService {
    public String addUser(UserDTO userDTO);

    LogInResponse logInUser(LoginDTO loginDTO);
}
