package org.lessons.pizzeria.security.pizzeria_security.security;

import java.util.Optional;

import org.lessons.pizzeria.security.pizzeria_security.model.User;
import org.lessons.pizzeria.security.pizzeria_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class DatabaseUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userAttempt = userRepository.findByUsername(username);

        if (userAttempt.isEmpty()) {
            throw new UsernameNotFoundException("Username '" + username + "' not found");
        }
        return new DatabaseUserDetails(userAttempt.get());
    }
}
