package api.service;

import api.model.DTOs.RegisterDTO;
import api.model.User;
import api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class RegisterService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity register (RegisterDTO registerDTO){
        if(userRepository.findByLogin(registerDTO.login()) != null){
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassord = new BCryptPasswordEncoder().encode(registerDTO.password());
        User newUser = new User ();
        newUser.setId(newUser.getId());
        newUser.setLogin(registerDTO.login());
        newUser.setPassword(encryptedPassord);
        newUser.setUserRole(registerDTO.userRole());
        userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }
}
