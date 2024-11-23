package api.service;

import api.model.DTOs.LoginDTO;
import api.model.User;
import api.repository.UserRepository;
import api.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String login (LoginDTO loginDTO) {
        User user = (User) userRepository.findByLogin(loginDTO.login());
        if (user!= null){
            var usernamePassord = new UsernamePasswordAuthenticationToken(loginDTO.login(), loginDTO.password());
            var auth = this.authenticationManager.authenticate(usernamePassord);
            var token = tokenService.generateToken((User) auth.getPrincipal());
            return token;
        } else{
            return null;
        }
    }
}
