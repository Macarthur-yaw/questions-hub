package com.example.pastQuestions.services;

import com.example.pastQuestions.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public  UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{
        return userRepository.findByEmailAddress(username).orElseThrow(()->
         new UsernameNotFoundException("user not found")
        );
    }

}
