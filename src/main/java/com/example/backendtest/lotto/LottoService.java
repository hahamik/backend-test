package com.example.backendtest.lotto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LottoService {
    private final LottoRepository lottosRepository;
}
