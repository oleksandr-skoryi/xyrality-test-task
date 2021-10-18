package com.xyrality.service;


import com.xyrality.model.Player;
import com.xyrality.util.LotteryEvaluatorUtil;
import java.util.Arrays;

/**
 * Singleton class for lottery evaluator. Provide only one instance of evaluator in system
 *
 * @author Oleksandr Skoryi
 */

public class LotteryEvaluatorService {

    private static LotteryEvaluatorService lotteryEvaluator;

    private final String winningCombination;

    private LotteryEvaluatorService(final String winningCombination) {
        this.winningCombination = winningCombination;
    }

    /**
     * Singleton
     *
     * @param winningCombination - winning combination from input
     * @return unique instance of LotteryEvaluator
     */
    public static LotteryEvaluatorService getInstance(final String winningCombination) {
        if (lotteryEvaluator == null) {
            lotteryEvaluator = new LotteryEvaluatorService(winningCombination);
        }
        return lotteryEvaluator;
    }

    /**
     * Method calculates winning points for all player's combinations
     *
     * @param player player to evaluate
     * @return sum of winning points for all player's combinations
     */
    public int evaluatePlayer(final Player player) {
        return Arrays.stream(player.getLotteryCombinations())
                .mapToInt(this::evaluateCombination)
                .sum();
    }

    /**
     * Method evaluates one player combination using dynamic programming. Method based on dynamic matrix building.
     *
     * @param combination one player combination
     * @return evaluated value
     */
    private int evaluateCombination(final String combination) {
        final int[][] matrix = new int[2][combination.length() + 1];
        for (int xCounter = 1; xCounter < winningCombination.length() + 1; xCounter++) {
            for (int y = 1; y < matrix[0].length; y++) {
                if (winningCombination.charAt(xCounter - 1) == combination.charAt(y - 1)) {
                    matrix[1][y] = matrix[0][y - 1] + 1;
                } else {
                    matrix[1][y] = Math.max(matrix[1][y - 1], matrix[0][y]);
                }
            }
            LotteryEvaluatorUtil.shiftMatrix(matrix);
        }
        return matrix[matrix.length - 1][matrix[0].length - 1];
    }
}
