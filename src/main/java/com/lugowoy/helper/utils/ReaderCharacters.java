package com.lugowoy.helper.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
//TODO review documentation
public final class ReaderCharacters {

    /**
     * Constructs an object of this class.
     */
    public ReaderCharacters() {
    }

    /**
     * Reads characters from all files found at addresses in the {@code
     * pathsToFiles} argument and write to an array of type {@code char}.
     *
     * @param files the files array storing characters.
     * @return char an array filled with read characters.
     * @throws NullPointerException if the {@code pathsToFiles} is {@code
     * null}.
     * @throws NullPointerException if objects for reading characters, for some
     * reason is {@code null}.
     * @throws IOException if an I/O error occurs.
     */
    public char[] readCharacters(@NotNull final File... files)
            throws IOException {
        Objects.requireNonNull(files, "Files is null.");
        List<Character> charactersList = new ArrayList<>();
        FileInputStream fileStream = null;
        InputStreamReader streamReader = null;
        BufferedReader reader = null;
        for (File file : files) {
            Objects.requireNonNull(file, "File is null.");
            try {
                fileStream = new FileInputStream(file);
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

    public char[] readCharacters(@NotNull final InputStream inputStream) {
        Objects.requireNonNull("Input stream is null.");
        BufferedReader reader = null;
        String characters = "";
        try {
            reader = new BufferedReader(new InputStreamReader(inputStream));
            characters = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(reader, "Reader is null.").close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return characters.toCharArray();
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
