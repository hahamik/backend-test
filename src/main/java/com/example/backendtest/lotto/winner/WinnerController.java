package com.example.backendtest.lotto.winner;

import com.example.backendtest._core.util.Resp;
import com.example.backendtest.lotto.LottoResponse;
import com.example.backendtest.lotto.LottoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WinnerController {
    private final WinnerService winnerService;
    private final LottoService lottoService;

    // 테스트용 수동 호출용 배치
    @PostMapping("/winners/check")
    public void checkWinnerManually() {
        LottoResponse.NumListDTO latestLotto = lottoService.getLotto();
        winnerService.checkWinner(latestLotto);
    }

    // 실제 배치 (스케줄링, 참고용)
    @Scheduled(cron = "0 0 0 ? * SUN", zone = "Asia/Seoul")
    public ResponseEntity<?> checkWinnerScheduled() {
        LottoResponse.NumListDTO latestLotto = lottoService.getLotto();
        winnerService.checkWinner(latestLotto);
        return Resp.ok("추첨 완료");
    }
}
