package com.lugowoy.helper.filling.array.strings;

import org.apache.commons.lang3.ArrayUtils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Konstantin Lugowoy on 10.06.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.2
 *
 * A functional interface for reading character data from a file into an array of char type.
 */

@FunctionalInterface
public interface CharacterReader {

    /**
     * A functional method for reading characters from a file into an array of char type.
     *
     * @param fileName The name of the file from which the characters are read.
     * @return An array of characters that have been read from the file.
     */
    char[] read(String fileName);

    /**
     * The method of class for reading characters from a file into an array of char type.
     *
     * @param fileName The name of the file from which the characters are read.
     * @return An array of characters that have been read from the file.
     */
    static char[] readCharacters(String fileName) {
        ArrayList<Character> charactersList = new ArrayList<>();
        try {
            FileReader reader = new FileReader(ClassLoader.getSystemResource("characters/" + fileName + ".txt").getFile());
            int character;
            while ((character = reader.read()) != -1) {
                charactersList.add((char) character);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return ArrayUtils.toPrimitive(charactersList.toArray(new Character[charactersList.size()]));
    }

}
