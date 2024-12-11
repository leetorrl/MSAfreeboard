package com.freeborad.MSAfreeboard.Service;

import com.freeborad.MSAfreeboard.Dto.JoinDto;
import com.freeborad.MSAfreeboard.Entity.Role;
import com.freeborad.MSAfreeboard.Entity.User;
import com.freeborad.MSAfreeboard.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SignInService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public void join(JoinDto joinDto){
        User user = modelMapper.map(joinDto, User.class);
        user.setPassword(
                passwordEncoder.encode(joinDto.getPassword())
        );
        //권한이 학생이 아니라면 accept 를 false 로
        user.setAccept(user.getRole() == Role.ROLE_STUDENT);

        userRepository.save(user);

    }
}
