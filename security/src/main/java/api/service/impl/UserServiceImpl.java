package api.service.impl;

import api.model.DTOs.RegisterDTO;
import api.model.User;
import api.repository.UserRepository;
import api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {

    }


    public User create(User user) {
        User newUser = new User();
        newUser.setId(newUser.getId());
        newUser.setLogin(user.getLogin());
        newUser.setPassword(user.getPassword());
        newUser.setUserRole(user.getUserRole());
        return newUser;
    }


}
