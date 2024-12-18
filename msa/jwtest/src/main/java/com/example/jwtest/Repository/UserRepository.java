package com.example.jwtest.Repository;

import com.example.jwtest.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);  // 사용자명으로 사용자 찾기
    boolean existsByUsername(String username);  // 사용자 존재 여부 확인
    boolean findByusername(String username);


}
