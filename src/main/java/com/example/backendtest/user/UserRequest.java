package com.example.backendtest.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

public class UserRequest {

    @Data
    public static class SaveDTO {
        @NotBlank(message = "이름 필수")
        private String name;

        public User toEntity() {
            return User.builder()
                    .name(name)
                    .build();
        }
    }

    @Data
    public static class UpdateDTO {
        @NotBlank(message = "이름 필수")
        private String name;
    }
}
