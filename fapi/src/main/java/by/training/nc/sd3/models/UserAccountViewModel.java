package by.training.nc.sd3.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAccountViewModel implements UserDetails {

    private Long id;
    private String name;
    private String password;
    private String email;
    private boolean isAdmin;
    private boolean isBanned;

    public UserAccountViewModel() {
    }

    public UserAccountViewModel(Long id, String name, String password, String email, boolean isAdmin, boolean isBanned) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.isAdmin = isAdmin;
        this.isBanned = isBanned;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (isAdmin) {
            return Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isBanned;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !isBanned;
    }

    public String getEmail() {
        return email;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setIsBanned(boolean banned) {
        isBanned = banned;
    }

    public boolean getIsBanned() {
        return isBanned;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }
}
