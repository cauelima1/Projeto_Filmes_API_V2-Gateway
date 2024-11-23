package api.service;

import api.model.DTOs.LoginDTO;
import api.model.DTOs.RegisterDTO;
import api.model.User;
import api.repository.UserRepository;
import api.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    public ResponseEntity register (RegisterDTO registerDTO){
        if(userRepository.findByLogin(registerDTO.login()) != null){
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
        User newUser = new User (registerDTO.login(), encryptedPassword, registerDTO.userRole());
        this.userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }






}
