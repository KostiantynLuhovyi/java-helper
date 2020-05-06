package com.lugowoy.helper.utils;

import org.apache.commons.lang3.ArrayUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * The class provides functionality for reading characters from specific files.
 * <p>
 * Created by Konstantin Lugowoy on 10.06.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.6
 * @since 1.2
 */
public final class ReaderCharacters {

    /**
     * Constructs an object of this class.
     */
    public ReaderCharacters() {
    }

    /**
     * Reads characters from all files found at addresses in the {@code
     * pathsToFiles} argument and write to an array of type char.
     *
     * @param pathsToFiles paths to files storing characters.
     *
     * @return char array filled with read characters.
     *
     * @throws NullPointerException if the {@code pathsToFiles} is {@code
     * null}.
     * @throws NullPointerException if objects for reading characters, for some
     * reason is {@code null}.
     * @throws IOException if an I/O error occurs.
     */
    public char[] readCharacters(final String... pathsToFiles)
            throws IOException {
        Objects.requireNonNull(pathsToFiles,
                               "Array with paths to files is null.");
        List<Character> charactersList = new ArrayList<>();
        FileInputStream fileStream = null;
        InputStreamReader streamReader = null;
        BufferedReader reader = null;
        for (String fileName : pathsToFiles) {
            Objects.requireNonNull(fileName, "File path is null.");
            try {
                fileStream = new FileInputStream(fileName);
                streamReader = new InputStreamReader(fileStream, UTF_8);
                reader = new BufferedReader(streamReader);
                int character;
                while ((character = reader.read()) != -1) {
                    charactersList.add((char) character);
                }
            } finally {
                closeAllStreams(fileStream, streamReader, reader);
            }
        }
        return ArrayUtils.toPrimitive(charactersList.toArray(Character[]::new));
    }

    private void closeAllStreams(final FileInputStream fileStream,
                                 final InputStreamReader streamReader,
                                 final BufferedReader reader)
            throws IOException {
        Objects.requireNonNull(fileStream, "Stream is null.").close();
        Objects.requireNonNull(streamReader, "Stream is null.").close();
        Objects.requireNonNull(reader, "Reader is null.").close();
    }

}
