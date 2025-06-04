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
}
