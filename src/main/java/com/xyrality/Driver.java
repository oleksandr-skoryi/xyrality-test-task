package com.xyrality;

import com.xyrality.model.LotteryEvaluator;
import com.xyrality.model.Player;
import com.xyrality.util.FileUtil;

import java.util.List;

/**
 * Created by Oleksandr Skoryi on 22.03.16.
 */
public class Driver {

    public static void main(String[] args) {
        if (args.length == 3) {
            String inputFile = args[0];
            String outputFile = args[1];
            String winningCombination = args[2];
            LotteryEvaluator evaluator = LotteryEvaluator.getInstance(winningCombination);
            List<Player> players = FileUtil.readFile(inputFile);
            players.stream().forEach(evaluator::evaluatePlayer);
            FileUtil.writeFile(outputFile, players);
        } else {
            System.out.println("Please provide three command line params <input file name> <output file name> <winning combination>");
        }
    }
}
