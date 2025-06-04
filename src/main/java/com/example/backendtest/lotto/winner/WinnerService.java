package com.example.backendtest.lotto.winner;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WinnerService {
    private final WinnerRepository winnerRepository;
}
