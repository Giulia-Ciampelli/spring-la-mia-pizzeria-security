package org.lessons.pizzeria.security.pizzeria_security.security;

import java.util.HashSet;
import java.util.Set;

import org.lessons.pizzeria.security.pizzeria_security.model.Role;
import org.lessons.pizzeria.security.pizzeria_security.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class DatabaseUserDetails implements UserDetails {

    private final int id;
    private final String username;
    private final String password;

    // permessi
    private final Set<GrantedAuthority> authorities;

    public DatabaseUserDetails(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.authorities = new HashSet<GrantedAuthority>();

        // per ogni ruolo presente nell'utente, crea un'autorità
        for (Role userRole : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(userRole.getName()));
        }
    }

    // #region getter e setter
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    // #endregion getter e setter

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
