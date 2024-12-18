package com.example.jwtest.login;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@RequiredArgsConstructor
public class LoginUserDetails implements UserDetails {

    private final String username;
    private final String password;
    private final String role;
    private final long idx;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // "ROLE_" 접두사가 없을 경우에만 붙여줌
        String prefixedRole = this.role.startsWith("ROLE_") ? this.role : "ROLE_" + this.role;
        return List.of(() -> prefixedRole);
    }
}