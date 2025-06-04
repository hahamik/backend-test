package com.example.backendtest.lotto.winner;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class WinnerRepository {
    private final EntityManager em;

    public void save(Winner winner) {
        em.persist(winner);
    }
}
