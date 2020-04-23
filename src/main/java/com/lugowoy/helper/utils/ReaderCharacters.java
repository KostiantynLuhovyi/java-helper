package com.lugowoy.helper.utils;

import org.apache.commons.lang3.ArrayUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The class provides functionality for reading characters from specific files.
 * <p> Created by Konstantin Lugowoy on 10.06.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.4
 * @since 1.2
 */
public final class ReaderCharacters {

    private ReaderCharacters() {
    }

    /**
     * Gets the object of this class.
     *
     * @return the object of this class.
     */
    public static ReaderCharacters getReader() {
        return new ReaderCharacters();
    }

    /**
     * Reads characters from all files found at addresses in the {@code pathsToFiles} argument.
     * The read characters write to an array of type char and returned by the result of the method.
     *
     * @param pathToFiles paths to files storing characters.
     *
     * @return char array filled with read characters.
     *
     * @throws NullPointerException if the {@code pathsToFiles} argument is null.
     * @throws NullPointerException if objects for reading characters, for some reason is null.
     * @throws IOException if an I/O error occurs.
     * @see Objects#requireNonNull(Object)
     */
    public char[] readCharacters(String... pathToFiles) throws IOException {
        Objects.requireNonNull(pathToFiles);
        List<Character> charactersList = new ArrayList<>();
        BufferedReader reader = null;
        InputStream stream = null;
        try {
            for (String fileName : pathToFiles) {
                stream = new FileInputStream(fileName);
                reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
                int character;
                while ((character = reader.read()) != -1) {
                    charactersList.add((char) character);
                }
            }
        } finally {
            Objects.requireNonNull(stream).close();
            Objects.requireNonNull(reader).close();
        }
        return ArrayUtils.toPrimitive(charactersList.toArray(Character[]::new));
    }

}
