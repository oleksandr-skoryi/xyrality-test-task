package com.xyrality;

import com.xyrality.model.LotteryEvaluator;
import com.xyrality.model.Player;
import com.xyrality.util.FileUtil;

import java.util.List;

/**
 * Main Class
 *
 * @author Oleksandr Skoryi
 */
public class Driver {

    public static void main(String[] args) {
        if (args.length == 2) {
            String inputFile = args[0];
            String winningCombination = args[1];
            LotteryEvaluator evaluator = LotteryEvaluator.getInstance(winningCombination);
            List<Player> players = FileUtil.readFile(inputFile);
            players.stream().forEach(item -> item.increasePoints(evaluator.evaluatePlayer(item)));
            players.stream().filter(item -> item.getPoints() != 0).sorted().forEach(
                    System.out::println
            );
        } else {
            System.out.println("Please provide two command line params <input file name> <winning combination>");
        }
    }
}
