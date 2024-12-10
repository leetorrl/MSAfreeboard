package com.freeborad.ex01.Controller;

import com.freeborad.ex01.Dto.UserReqDto;
import com.freeborad.ex01.Entity.User;
import com.freeborad.ex01.Repository.UserRepository;
import com.freeborad.ex01.Response.UserResponseDto;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("user")
@CrossOrigin
@AllArgsConstructor

public class UserController {

    @Autowired
    private final UserRepository userRepository;

    @GetMapping("getuser")
    public ResponseEntity<List<UserResponseDto>> userdata (){

        List<User> users = userRepository.findAll();

        List<UserResponseDto> userResponseDtos = users.stream().map(user -> new UserResponseDto(user))
                .collect(Collectors.toList()); //List<UserResponseDto>로 수집

        return  ResponseEntity.ok(userResponseDtos);
    }


    @PostMapping("setuser")
    public ResponseEntity<String> usersave(@RequestBody UserReqDto userReqDto){

        User user = new User();

        user.setIdx(userReqDto.getIdx());
        user.setUsername(userReqDto.getUsername());
        user.setAge(userReqDto.getAge());
        user.setEmail(userReqDto.getEmail());
        user.setWdate(userReqDto.getWdate());
        user.setPassword(userReqDto.getPassword());
        user.setRole(userReqDto.getRole());

        userRepository.save(user);

        return ResponseEntity.status(200).body("success insert");
    }

}
