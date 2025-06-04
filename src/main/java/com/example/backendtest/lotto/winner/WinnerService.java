package com.example.backendtest.lotto.winner;

import com.example.backendtest.lotto.Lotto;
import com.example.backendtest.lotto.LottoRepository;
import com.example.backendtest.lotto.LottoResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WinnerService {
    private final WinnerRepository winnerRepository;
    private final LottoRepository lottoRepository;

    @Transactional
    public void checkWinner(LottoResponse.NumListDTO winningLotto) {
        List<Lotto> lottos = lottoRepository.findAll();
        List<Integer> winningNums = winningLotto.getNumbers();

        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatches(winningNums);
            int rank = 0;

            if (matchCount == 6) rank = 1;
            else if (matchCount == 5) rank = 2;
            else if (matchCount == 4) rank = 3;
            else if (matchCount == 3) rank = 4;
            else if (matchCount == 2) rank = 5;

            if (rank != 0) {
                Winner winner = Winner.builder()
                        .lotto(lotto)
                        .rank(rank)
                        .build();
                winnerRepository.save(winner);
            }
        }
    }
}
