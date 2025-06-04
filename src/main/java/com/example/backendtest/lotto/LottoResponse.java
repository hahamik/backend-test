package com.example.backendtest.lotto;

import lombok.Data;
import java.util.List;

public class LottoResponse {

    @Data
    public static class NumListDTO {
        private List<Integer> numbers;

        public NumListDTO(List<Integer> numbers) {
            this.numbers = numbers;
        }
    }
}
