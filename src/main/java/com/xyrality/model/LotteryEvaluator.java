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
        int[][] matrix = new int[winningCombination.length() + 1][combination.length() + 1];
        for (int x = 1; x < matrix.length; x++) {
            for (int y = 1; y < matrix[x].length; y++) {
                if (winningCombination.charAt(x-1) == combination.charAt(y-1)) {
                    matrix[x][y] = matrix[x - 1][y - 1] + 1;
                } else {
                    matrix[x][y] = Math.max(matrix[x][y - 1], matrix[x - 1][y]);
                }
            }
        }
        return matrix[matrix.length - 1][matrix[0].length - 1];
    }

    private static void printMatrix(int[][] matrix) {
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
