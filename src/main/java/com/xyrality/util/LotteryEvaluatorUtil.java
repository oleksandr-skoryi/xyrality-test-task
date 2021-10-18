package com.xyrality.util;

/**
 * Util class for lottery evaluator
 *
 * @author Oleksandr Skoryi
 */
public class LotteryEvaluatorUtil {

    private LotteryEvaluatorUtil() {}

    /**
     * Shift line to up
     *
     * @param matrix to shift line
     */
    public static void shiftMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[0][i] = matrix[1][i];
        }
    }

    /**
     * Helper method for debug purposes, just print matrix
     *
     * @param matrix matrix for printing
     */
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
