package ua.pdp.exam_6.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.pdp.exam_6.model.Role;
import ua.pdp.exam_6.model.User;
import ua.pdp.exam_6.repository.UserRepo;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static java.util.Collections.emptyList;


@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    UserRepo userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username yoki parol xato!"));
        Optional<User> byUsername = userRepository.findByUsername(username);
        if (byUsername.isPresent()) {
            User user = byUsername.get();
            System.out.println("username: "+user.getUsername());
            System.out.println("password: "+user.getPassword());
            System.out.println("username: "+username);
            System.out.println(getAuthority(user));
            return new org.springframework.security.core.userdetails.User(username, user.getPassword(), getAuthority(user));
        }
        throw new UsernameNotFoundException(username);
    }

    private Set getAuthority(User user) {
        Set authorities = new HashSet<>();
        Set<Role> roles = user.getRoles();


        roles.forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return authorities;
    }

}

