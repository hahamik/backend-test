package com.example.backendtest.lotto;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@Table(name = "lottos_tb")
@Entity
public class Lotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int num1;
    private int num2;
    private int num3;
    private int num4;
    private int num5;
    private int num6;

    @Builder
    public Lotto(Long id, int num1, int num2, int num3, int num4, int num5, int num6) {
        this.id = id;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.num5 = num5;
        this.num6 = num6;
    }

    public int countMatches(List<Integer> winNums) {
        List<Integer> myNums = List.of(num1, num2, num3, num4, num5, num6);
        int count = 0;
        for (Integer num : myNums) {
            if (winNums.contains(num)) {
                count++;
            }
        }
        return count;
    }
}
