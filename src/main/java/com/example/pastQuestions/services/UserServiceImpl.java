package com.example.pastQuestions.services;

import com.example.pastQuestions.dto.LoginOutputDto;
import com.example.pastQuestions.dto.LoginRequestDto;
import com.example.pastQuestions.dto.UserInputDto;
import com.example.pastQuestions.dto.UserOutputDto;
import com.example.pastQuestions.entity.User;
import com.example.pastQuestions.mappers.UserMapper;
import com.example.pastQuestions.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
private final UserMapper userMapper;
private final JwtService jwtService;
private final AuthenticationManager authenticationManager;
    @Override
    @Transactional
    public UserOutputDto registerUser(UserInputDto userInputDto) {

        Optional<User> user=userRepository.findByEmailAddress(userInputDto.emailAddress());
        if(user.isPresent()){
            throw  new RuntimeException(MessageFormat.format("cant find email",userInputDto.emailAddress()));
        }

        User setUser=User.builder().firstName(userInputDto.firstName()).middleName(userInputDto.middleName()).lastName(userInputDto.lastName()).emailAddress(userInputDto.emailAddress()).password(passwordEncoder.encode(userInputDto.password())).build();
        User savedUser=userRepository.save(setUser);
        return new UserOutputDto(
                setUser.getFirstName(),
                setUser.getMiddleName(),
                setUser.getLastName(),
                setUser.getEmailAddress(),
                setUser.getUserRole().name(),
                setUser.getId(),
                jwtService.generateToken(savedUser)
                , jwtService.generateToken(savedUser)
        );
    }

    @Override
    public LoginOutputDto loginUser(LoginRequestDto loginRequestDto) {

        Optional<User> findUser=userRepository.findByEmailAddress(loginRequestDto.emailAddress());

        if(findUser.isEmpty()){
            throw new RuntimeException(MessageFormat.format("Can not find email address",loginRequestDto.emailAddress()));
        }

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.emailAddress(),loginRequestDto.password()));

        return new LoginOutputDto(loginRequestDto.emailAddress(), jwtService.generateToken(findUser.get()), jwtService.generateToken(findUser.get()) );

    }
}
