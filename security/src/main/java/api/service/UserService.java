package api.service;

import api.model.DTOs.RegisterDTO;
import api.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    Optional<User> findById(Long id);

    List<User> findAll();

    void delete (Long id);

    User create(User user);

}
