package com.example.jwtest.Service;

import com.example.jwtest.Entity.User;
import com.example.jwtest.Repository.UserRepository;
import com.example.jwtest.ReqDto.UserReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 사용자 인증
    public User authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }

    // 사용자 등록
    public void registerUser(UserReqDto userReqDto) {

        // 비밀번호를 암호화하여 저장

        User user = new User();

        LocalDateTime newdate = LocalDateTime.now();

        if (userRepository.existsByUsername(userReqDto.getUsername())) {
            throw new IllegalArgumentException("Username is already taken");
        }

        user.setUsername(userReqDto.getUsername());
        user.setPassword(passwordEncoder.encode(userReqDto.getPassword()));
        user.setRole(userReqDto.getRole());
        user.setEmail(userReqDto.getEmail());
        user.setWdate(newdate);
        userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }


    public Optional<User> findByUserIdx(long idx) {
        return userRepository.findById(idx);  // findById(idx)를 사용하여 사용자 조회
    }
}