package com.example.backendtest.user;

import com.example.backendtest._core.error.ex.ExceptionApi404;
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
        User userPS = userRepository.findById(id)
                .orElseThrow(() -> new ExceptionApi404("해당 유저를 찾을 수 없습니다"));
        return new UserResponse.DTO(userPS);
    }

    @Transactional
    public UserResponse.DTO update(Long id, UserRequest.UpdateDTO reqDTO) {
        User userPS = userRepository.findById(id)
                .orElseThrow(() -> new ExceptionApi404("수정할 유저를 찾을 수 없습니다"));
        userPS.update(reqDTO.getName());
        return new UserResponse.DTO(userPS);
    }
}
