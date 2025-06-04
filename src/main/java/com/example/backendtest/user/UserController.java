package com.example.backendtest.user;

import com.example.backendtest._core.util.Resp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<?> save(@RequestBody UserRequest.SaveDTO reqDTO) {
        UserResponse.SaveDTO respDTO = userService.save(reqDTO);
        return Resp.ok(respDTO);
    }
}
