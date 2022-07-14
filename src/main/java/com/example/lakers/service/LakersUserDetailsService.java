package com.example.lakers.service;

import com.example.lakers.model.entity.UserEntity;
import com.example.lakers.model.user.LakersUserDetails;
import com.example.lakers.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class LakersUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public LakersUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).map(this::map).orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " not found!"));
    }

    private UserDetails map(UserEntity userEntity) {

        return new LakersUserDetails(userEntity.getPassword(), userEntity.getEmail(), userEntity.)
    }
}
