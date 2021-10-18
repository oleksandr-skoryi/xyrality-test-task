package com.xyrality.util;

import com.xyrality.model.Player;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Util class for I/O operations
 *
 * @author Oleksandr Skoryi
 */
public class FileUtil {

    private FileUtil() {
    }

    /**
     * Method reads input file and convert file content to list of players. If file doesn't exist, there is no
     * reason to proceed the work of program
     *
     * @param filename input file name
     * @return data converted to list of players
     */
    public static List<Player> readFile(final String filename) throws IOException {

        try (final Stream<String> lines = Files.lines(Paths.get(filename))) {

            return lines.map(FileUtil::parsePlayer)
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
     * @param line - line from file
     * @return parsed Player from entry
     */
    private static Player parsePlayer(final String line) {
        final String[] playerProps = line.split(",");
        final String[] lotteryCombinations = Arrays.copyOfRange(playerProps, 3, playerProps.length);
        return new Player(playerProps[0], playerProps[1], playerProps[2], lotteryCombinations);
    }

}
