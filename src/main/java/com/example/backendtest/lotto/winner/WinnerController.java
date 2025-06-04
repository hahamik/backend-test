package com.example.backendtest.lotto.winner;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WinnerController {
    private final WinnerService winnerService;
}
