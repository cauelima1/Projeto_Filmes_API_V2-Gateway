package api.model.DTOs;

import api.model.UserRole;


public record RegisterDTO(String login, String password, UserRole userRole) {


}
