package com.example.backendtest.lotto;

import com.example.backendtest._core.util.Resp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LottoController {
    private final LottoService lottoService;

    @PostMapping("/lottos")
    public ResponseEntity<?> getLotto() {
        LottoResponse.NumListDTO respDTO = lottoService.getLotto();
        return Resp.ok(respDTO);
    }
}
