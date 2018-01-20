package com.xyrality;

import com.xyrality.logic.LotteryEvaluator;
import com.xyrality.model.Player;
import com.xyrality.util.FileUtil;

import java.io.IOException;
import java.util.List;

/**
 * Main Class
 *
 * @author Oleksandr Skoryi
 */
public class Driver {

    public static void main(String[] args) {
        if (args.length == 2) {
            try {
                final String inputFile = args[0];
                final String winningCombination = args[1];
                final LotteryEvaluator evaluator = LotteryEvaluator.getInstance(winningCombination);
                final List<Player> players = FileUtil.readFile(inputFile);
                players.forEach(item -> item.increasePoints(evaluator.evaluatePlayer(item)));
                players.stream().filter(item -> item.getPoints() != 0)
                        .sorted()
                        .forEach(
                                System.out::println
                        );
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("Please provide two command line params <input file name> <winning combination>");
        }
    }
}
