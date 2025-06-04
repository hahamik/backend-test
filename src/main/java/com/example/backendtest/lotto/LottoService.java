package com.example.backendtest.lotto;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LottoService {
    private final LottoRepository lottosRepository;

    @Transactional
    public LottoResponse.NumListDTO getLotto() {
        Set<Integer> nums = new HashSet<>();
        Random random = new Random();

        while (nums.size() < 6) {
            nums.add(random.nextInt(45) + 1);
        }

        List<Integer> numbers = nums.stream()
                .sorted()
                .collect(Collectors.toList());

        Lotto lotto = Lotto.builder()
                .num1(numbers.get(0))
                .num2(numbers.get(1))
                .num3(numbers.get(2))
                .num4(numbers.get(3))
                .num5(numbers.get(4))
                .num6(numbers.get(5))
                .build();
        lottosRepository.save(lotto);

        return new LottoResponse.NumListDTO(numbers);
    }

}
