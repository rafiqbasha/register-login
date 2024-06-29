package com.techrovar.serviceImpl;

import com.techrovar.dto.LoginDTO;
import com.techrovar.dto.UserDTO;
import com.techrovar.entities.User;
import com.techrovar.paylodresponse.LogInMessage;
import com.techrovar.paylodresponse.LogInResponse;
import com.techrovar.repositories.UserRepository;
import com.techrovar.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addUser(UserDTO userDTO) {
            User user = new User(
                    userDTO.getId(),
                    userDTO.getUsername(),
                    userDTO.getEmail(),
                    this.passwordEncoder.encode(userDTO.getPassword())
               );
        userRepository.save(user);
        logger.info("User registered successfully: {}", user.getUsername());


        return user.getUsername() + " Registered successfully";
    }

    @Override
    public LogInResponse logInUser(LoginDTO loginDTO) {
        String msg = "";
        User user1 = userRepository.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);

            if (isPwdRight) {
                Optional<User> user = userRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LogInResponse("Log in success", true);
                } else {
                    return new LogInResponse("Log in failure", false);
                }
            } else {
                return new LogInResponse("Password not match", false);
            }
        } else {
            return new LogInResponse("Email not exists", false);
        }
    }

}
