package com.xyrality.model;

import java.util.List;

/**
 * Created by Oleksandr Skoryi on 23.03.16.
 */
public class LotteryEvaluator {

    private static LotteryEvaluator lotteryEvaluator;
    private String winningCombination;

    private LotteryEvaluator(String winningCombination) {
        this.winningCombination = winningCombination;
    }

    public static LotteryEvaluator getInstance(String winningCombination) {
        if (lotteryEvaluator == null) {
            lotteryEvaluator = new LotteryEvaluator(winningCombination);
        }
        return lotteryEvaluator;
    }

    public void evaluatePlayer(Player player) {
        List<String> lotteryCombinations = player.getLotteryCombinations();
        for (String combination : lotteryCombinations) {
            player.increasePoints(evaluateCombination(combination));
        }
    }

    private int evaluateCombination(String combination) {

        return 2;
    }
}
