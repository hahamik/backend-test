package com.example.backendtest.lotto;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LottoRepository {
    private final EntityManager em;
}
