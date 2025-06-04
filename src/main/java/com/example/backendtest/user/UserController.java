package com.example.backendtest.user;

import com.example.backendtest._core.util.Resp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<?> save(@RequestBody UserRequest.SaveDTO reqDTO) {
        UserResponse.SaveDTO respDTO = userService.save(reqDTO);
        return Resp.ok(respDTO);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> find(@PathVariable("id") Long id) {
        UserResponse.DTO respDTO = userService.find(id);
        return Resp.ok(respDTO);
    }
}
