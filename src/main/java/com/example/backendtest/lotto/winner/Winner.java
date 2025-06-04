package com.example.backendtest.lotto.winner;

import com.example.backendtest.lotto.Lotto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Table(name = "winner_tb")
@Entity
public class Winner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "lotto_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Lotto lotto;

    private int rank;
}
