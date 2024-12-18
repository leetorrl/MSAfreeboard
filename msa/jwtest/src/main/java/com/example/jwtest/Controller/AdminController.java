package com.example.jwtest.Controller;

import com.example.jwtest.Entity.User;
import com.example.jwtest.ReqDto.JoinReqDto;
import com.example.jwtest.ReqDto.UserReqDto;
import com.example.jwtest.ResDto.UserResDto;
import com.example.jwtest.Service.UserService;
import com.example.jwtest.jwt.JwtUtils;
import com.example.jwtest.login.LoginUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class AdminController {

    private final JwtUtils jwtUtils;
   private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody JoinReqDto joinReqDto) {

        //사용자 인증
        User user = userService.authenticate(joinReqDto.getUsername(), joinReqDto.getPassword());
        if(user == null){
            return ResponseEntity.status(401).body("유저 읎다");
        }

        //jwt토큰 생성
        String token = jwtUtils.generateToken(user.getUsername());

        return ResponseEntity.ok(token);

    }

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody UserReqDto userReqDto){
        //사용자 등록
        userService.registerUser(userReqDto);
        return ResponseEntity.ok("유저 생성 완료");
    }


    @GetMapping("/list")
    public ResponseEntity<List<User>> getuserlist(@AuthenticationPrincipal LoginUserDetails loginUserDetails){

        // 현재 로그인한 사용자 정보를 이용하여 필요한 로직 추가 가능 (예: 권한 체크 등)
        List<User> userList = userService.findAllUsers();

        log.info(userList.toString());

        return ResponseEntity.ok(userList);
    }





}
