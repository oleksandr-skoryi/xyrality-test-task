package com.xyrality;

import com.xyrality.model.LotteryEvaluator;
import com.xyrality.model.Player;
import com.xyrality.util.FileUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Main Class
 *
 * @author Oleksandr Skoryi
 */
public class Driver {

    public static void main(String[] args) {
        if (args.length == 3) {
            String inputFile = args[0];
            String outputFile = args[1];
            String winningCombination = args[2];
            LotteryEvaluator evaluator = LotteryEvaluator.getInstance(winningCombination);
            List<Player> players = FileUtil.readFile(inputFile);
            players.stream().forEach(item -> item.increasePoints(evaluator.evaluatePlayer(item)));
            players = players.stream().filter(item -> item.getPoints() != 0).sorted().collect(Collectors.toList());
            FileUtil.writeFile(outputFile, players);
        } else {
            System.out.println("Please provide three command line params <input file name> <output file name> <winning combination>");
        }
    }
}
