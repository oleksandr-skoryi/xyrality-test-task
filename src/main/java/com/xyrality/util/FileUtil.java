package com.xyrality.util;

import com.xyrality.model.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Util class for I/O operations
 *
 * @author Oleksandr Skoryi
 */
public class FileUtil {

    /**
     * Method reads input file and convert file content to list of players. If file doesn't exist, there is no
     * reason to proceed the work of program
     *
     * @param filename input file name
     * @return data converted to list of players
     */
    public static List<Player> readFile(String filename) throws IOException {
        List<Player> players = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            Map<String, List<String>> helpersMap = new HashMap<>();
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                putValueInMap(helpersMap, currentLine);
            }
            players.addAll(helpersMap.entrySet().stream().map(FileUtil::getPlayerFromEntry).collect(Collectors.toList()));
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("File " + filename + " not found");
        } catch (IOException ex) {
            throw new IOException("File " + filename + " has error during reading");
        }
        return players;
    }

    /**
     * Method for creation Player from entry
     *
     * @param entry map entry
     * @return parsed Player from entry
     */
    private static Player getPlayerFromEntry(Map.Entry<String, List<String>> entry) {
        String[] playerProps = entry.getKey().split(",");
        List<String> lotteryCombinations = entry.getValue();
        return new Player(playerProps[0], playerProps[1], playerProps[2], lotteryCombinations);
    }

    /**
     * Method provides the fastest way to read file and create the data structure, which after can be easily converted
     * to list of players
     *
     * @param helperMap - helper map to contain info in format lastName,firstName,Country->List(Combinations)
     * @param line      one line from file
     */
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
