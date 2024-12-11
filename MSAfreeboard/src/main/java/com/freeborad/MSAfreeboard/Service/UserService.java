package com.freeborad.MSAfreeboard.Service;

import com.freeborad.MSAfreeboard.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

}
