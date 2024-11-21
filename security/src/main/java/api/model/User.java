package api.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String login;
    private String password;
    private UserRole userRole;

    public User(UUID id, String login, String password, UserRole userRole) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.userRole = userRole;
    }

    public User(String login, String encryptedPassord, UserRole userRole) {
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public User(String login, String encryptedPassord, UserRole perfil, UserRole userRole) {
        this.userRole = userRole;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.userRole == UserRole.MODERADOR){
            return List.of(new SimpleGrantedAuthority("ROLE_MODERADOR"));
        } if(this.userRole == UserRole.AVANCADO) {
            return List.of(new SimpleGrantedAuthority("ROLE_AVANCADO"));
        } if (this.userRole == UserRole.BASICO) {
            return List.of(new SimpleGrantedAuthority("ROLE_BASICO"));
        } if (this.userRole == UserRole.LEITOR) {
            return List.of(new SimpleGrantedAuthority("ROLE_LEITOR"));
        }
        return List.of();
    }
    
    public User(){
        
    }
}
