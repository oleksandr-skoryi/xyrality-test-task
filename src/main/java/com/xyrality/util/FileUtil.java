package com.xyrality.util;

import com.xyrality.model.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Oleksandr Skoryi on 22.03.16.
 */
public class FileUtil {

    public static List<Player> readFile(String filename) {
        List<Player> players = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            Map<String, List<String>> helpersMap = new HashMap<>();
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                putValueInMap(helpersMap, currentLine);
            }
            players.addAll(helpersMap.entrySet().stream().map(FileUtil::getPlayerFromEntry).collect(Collectors.toList()));
        } catch (FileNotFoundException ex) {
            System.out.println("File " + filename + " not found");
        } catch (IOException ex) {
            System.out.println("File " + filename + " has error during reading");
        }
        return players;
    }

    public static void writeFile(String filename, List<Player> players) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Player player : players) {
                bw.write(player.toFileFormat() + System.getProperty("line.separator"));
            }
        } catch (IOException ex) {
            System.out.println("File " + filename + " has error during writing");
        }
    }

    private static Player getPlayerFromEntry(Map.Entry<String, List<String>> entry) {
        String[] playerProps = entry.getKey().split(",");
        List<String> lotteryCombinations = entry.getValue();
        return new Player(playerProps[0], playerProps[1], playerProps[2], lotteryCombinations);
    }

    private static void putValueInMap(Map<String, List<String>> helperMap, String line) {
        String keyForHelpersMap = line.substring(0, line.lastIndexOf(","));
        String lotteryCombination = line.substring(line.lastIndexOf(",") + 1, line.length());
        if (helperMap.containsKey(keyForHelpersMap)) {
            helperMap.get(keyForHelpersMap).add(lotteryCombination);
        } else {
            helperMap.put(keyForHelpersMap, new ArrayList<String>() {{
                        add(lotteryCombination);
                    }}
            );
        }
    }
}
