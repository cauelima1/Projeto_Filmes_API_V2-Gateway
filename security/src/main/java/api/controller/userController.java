package api.controller;

import api.model.DTOs.RegisterDTO;
import api.model.User;
import api.repository.UserRepository;
import api.service.RegisterService;
import api.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {

    private final UserService userService;
    private final RegisterService registerService;
    private final UserRepository userRepository;

    public userController(UserService userService, RegisterService registerService, UserRepository userRepository) {
        this.userService = userService;
        this.registerService = registerService;
        this.userRepository = userRepository;
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Validated RegisterDTO registerDTO) {
        return (registerService.register(registerDTO));
    }

    @GetMapping
    public ResponseEntity<List<User>> showAllUsers(){
        return ResponseEntity.ok(userRepository.findAll());
    }

}
