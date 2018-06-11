package com.lugowoy.helper.filling.array.strings;

import org.apache.commons.lang3.ArrayUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

/**
 * Created by Konstantin Lugowoy on 10.06.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 *
 *
 *
 * */
//todo Add doc's;
@FunctionalInterface
public interface CharacterReader {

    char[] read(String fileName);

    static char[] readCharacters(String fileName) {
        ArrayList<Character> charactersList = new ArrayList<>();
        try {
            FileReader reader = new FileReader(ClassLoader.getSystemResource("characters/" + fileName + ".txt").getFile());
            int character;
            while ((character = reader.read()) != -1) {
                charactersList.add((char) character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ArrayUtils.toPrimitive(charactersList.toArray(new Character[charactersList.size()]));
    }

}
