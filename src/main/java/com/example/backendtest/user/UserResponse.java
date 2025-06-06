package com.example.backendtest.user;

import lombok.Data;

public class UserResponse {

    @Data
    public static class SaveDTO {
        private Long id;

        public SaveDTO(User user) {
            this.id = user.getId();
        }
    }

    @Data
    public static class DTO {
        private Long id;
        private String name;

        public DTO(User user) {
            this.id = user.getId();
            this.name = user.getName();
        }
    }
}
