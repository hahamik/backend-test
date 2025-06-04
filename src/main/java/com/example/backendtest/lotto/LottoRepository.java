package com.example.backendtest.lotto;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LottoRepository {
    private final EntityManager em;

    public void save(Lotto lotto) {
        em.persist(lotto);
    }

    public List<Lotto> findAll() {
        return em.createQuery("select l from Lotto l", Lotto.class)
                .getResultList();
    }
}
