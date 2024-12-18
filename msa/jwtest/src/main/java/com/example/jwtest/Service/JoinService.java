package com.example.jwtest.Service;

import com.example.jwtest.Entity.User;
import com.example.jwtest.Repository.UserRepository;
import com.example.jwtest.ReqDto.JoinReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinService(JoinReqDto joinReqDto){

        User user = new User();
        user.setUsername((joinReqDto.getUsername()));
        user.setPassword((joinReqDto.getPassword()));

        if(userRepository.findByusername(joinReqDto.getUsername())){

            return;
        }

        userRepository.save(user);
    }

    public void joinProcess(JoinReqDto joinReqDto) {

    }
}
