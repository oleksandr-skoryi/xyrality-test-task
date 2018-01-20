package com.xyrality.util;

import com.xyrality.model.Player;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public static List<Player> readFile(final String filename) throws IOException {

        try (final Stream<String> lines = Files.lines(Paths.get(filename))) {

            final Map<String, List<String>> helpersMap = new HashMap<>();
            lines.forEach(currentLine -> {
                final String keyForHelpersMap = currentLine.substring(0, currentLine.lastIndexOf(","));
                final String lotteryCombination = currentLine.substring(currentLine.lastIndexOf(",") + 1, currentLine.length());
                helpersMap.computeIfAbsent(keyForHelpersMap, elem -> new ArrayList<>()).add(lotteryCombination);
            });
            return helpersMap
                    .entrySet()
                    .stream()
                    .map(FileUtil::getPlayerFromEntry)
                    .collect(Collectors.toList());

        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("File " + filename + " not found");
        } catch (IOException ex) {
            throw new IOException("File " + filename + " has error during reading");
        }
    }

    /**
     * Method for creation Player from entry
     *
     * @param entry map entry
     * @return parsed Player from entry
     */
    private static Player getPlayerFromEntry(final Map.Entry<String, List<String>> entry) {
        final String[] playerProps = entry.getKey().split(",");
        final List<String> lotteryCombinations = entry.getValue();
        return new Player(playerProps[0], playerProps[1], playerProps[2], lotteryCombinations);
    }

}
