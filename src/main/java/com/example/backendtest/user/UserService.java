package com.example.backendtest.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponse.SaveDTO save(UserRequest.SaveDTO reqDTO) {
        User userPS = userRepository.save(reqDTO.toEntity());
        return new UserResponse.SaveDTO(userPS);
    }

    public UserResponse.DTO find(Long id) {
        User userPS = userRepository.findById(id);
        return new UserResponse.DTO(userPS);
    }

    @Transactional
    public UserResponse.DTO update(Long id, UserRequest.UpdateDTO reqDTO) {
        User userPS = userRepository.findById(id);
        userPS.update(reqDTO.getName());
        return new UserResponse.DTO(userPS);
    }
}
