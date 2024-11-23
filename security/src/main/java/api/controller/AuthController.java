package api.controller;

import api.model.DTOs.LoginDTO;
import api.model.DTOs.RegisterDTO;
import api.model.DTOs.tokenDTO;
import api.model.User;
import api.repository.UserRepository;
import api.service.LoginService;
import api.service.RegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final LoginService loginService;
    private final RegisterService registerService;
    private final UserRepository userRepository;

    public AuthController(LoginService loginService, RegisterService registerService, UserRepository userRepository) {
        this.loginService = loginService;
        this.registerService = registerService;
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Validated RegisterDTO registerDTO) {
        return (registerService.register(registerDTO));
    }

    @PostMapping("/login")
    public ResponseEntity login (@RequestBody @Validated LoginDTO loginDTO)  {
        var token = loginService.login(loginDTO);
        return ResponseEntity.ok(new tokenDTO(token));
    }


    @GetMapping("/users")
    public ResponseEntity<List<User>> showAllUsers(){
        return ResponseEntity.ok(userRepository.findAll());
    }

}
