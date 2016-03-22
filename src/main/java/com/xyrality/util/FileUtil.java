package com.xyrality.util;

import com.xyrality.model.Player;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by homedevelop on 22.03.16.
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
            System.out.println(helpersMap);
        } catch (FileNotFoundException ex) {
            System.out.println("File " + filename + " not found");
        } catch (IOException ex) {
            System.out.println("File " + filename + " has error during reading");
        }
        return players;
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
