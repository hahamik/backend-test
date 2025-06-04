package com.example.backendtest.lotto;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LottoController {
    private final LottoService lottoService;

}
