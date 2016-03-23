package com.xyrality.model;


import com.xyrality.util.LotteryEvaluatorUtil;

/**
 * Singleton class for lottery evaluator. Provide only one instance of evaluator in system
 *
 * @author Oleksandr Skoryi
 */

public class LotteryEvaluator {

    private static LotteryEvaluator lotteryEvaluator;
    private String winningCombination;

    private LotteryEvaluator(String winningCombination) {
        this.winningCombination = winningCombination;
    }

    /**
     * Singleton realisation
     *
     * @param winningCombination - winning combination from command line param
     * @return unique instance of LotteryEvaluator
     */
    public static LotteryEvaluator getInstance(String winningCombination) {
        if (lotteryEvaluator == null) {
            lotteryEvaluator = new LotteryEvaluator(winningCombination);
        }
        return lotteryEvaluator;
    }

    /**
     * Method calculates winning points for all player's combinations
     *
     * @param player player to evaluate
     * @return sum of winning points for all player's combinations
     */
    public int evaluatePlayer(Player player) {
        return player.getLotteryCombinations().stream().mapToInt(this::evaluateCombination).sum();
    }

    /**
     * Method evaluates one player combination using dynamic programming. Method based on dynamic matrix building.
     *
     * @param combination one player combination
     * @return evaluated value
     */
    private int evaluateCombination(String combination) {
        int[][] matrix = new int[2][combination.length() + 1];
        int xCounter = 1;
        while (xCounter < winningCombination.length() + 1) {
            for (int y = 1; y < matrix[0].length; y++) {
                if (winningCombination.charAt(xCounter - 1) == combination.charAt(y - 1)) {
                    matrix[1][y] = matrix[0][y - 1] + 1;
                } else {
                    matrix[1][y] = Math.max(matrix[1][y - 1], matrix[0][y]);
                }
            }
            LotteryEvaluatorUtil.shiftMatrix(matrix);
            xCounter++;
        }
        return matrix[matrix.length - 1][matrix[0].length - 1];
    }
}
