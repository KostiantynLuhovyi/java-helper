package com.lugowoy.helper.filling.array.strings;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.checkers.CheckerBoundNumber;
import com.lugowoy.helper.checkers.CheckerString;
import com.lugowoy.helper.filling.array.FillingArrayReadValues;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.LengthOutOfRangeException;
import org.jetbrains.annotations.NotNull;

import java.io.Reader;

/**
 * The class provides functionality to reads data for fills an object of the
 * {@link Array} class and classical arrays with object of the {@link String}
 * type.
 * <p>Created by Konstantin Lugowoy on 10.06.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 * @see com.lugowoy.helper.filling.FillingReadValues
 * @see com.lugowoy.helper.filling.array.FillingArrayReadValues
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.strings.FillingArrayStrings
 */
//TODO review documentation
public class FillingArrayReadStrings extends FillingArrayReadValues
        implements FillingArrayStrings<Integer> {

    public FillingArrayReadStrings(final @NotNull Reader reader) {
        super(reader);
    }

    /**
     * Fills an object of the {@link Array} class with object of the {@link
     * String} type.
     *
     * @param array The object of the {@link Array} class to be filled with
     * object of the {@link String} type.
     */
    @Override
    public void fill(@NotNull final Array<String> array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        String[] strings = new String[array.size()];
        this.fillArrayReadStrings(strings);
        array.setArray(strings);
    }

    /**
     * Fills an array with object of the {@link String} type.
     *
     * @param array The array to be filled with object of the {@link String}
     * type.
     */
    @Override
    public void fill(@NotNull final String[] array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        this.fillArrayReadStrings(array);
    }

    /**
     * Fills an array with object of the {@link String} type.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     *
     * @param lengthArray The length(size) of the array to be filled with object
     * of the {@link String} type.
     * @return Created and filled array with object of the {@link String} type.
     */
    @Override
    public String[] fill(final int lengthArray) {
        CheckerArray.check(lengthArray);
        String[] strings = new String[lengthArray];
        this.fillArrayReadStrings(strings);
        return strings;
    }

    @Override
    public void fill(@NotNull final Array<String> array,
                     @NotNull final Integer lengthString) {
        CheckerArray.check(array, Capacity.UPPER.get());
        CheckerString.check(lengthString, Capacity.UPPER.get());
        String[] strings = new String[array.size()];
        this.fillArrayReadStringsLengthToBound(strings, lengthString);
        array.setArray(strings);
    }

    @Override
    public void fill(@NotNull final String[] array,
                     @NotNull final Integer lengthString) {
        CheckerArray.check(array, Capacity.UPPER.get());
        CheckerString.check(lengthString, Capacity.UPPER.get());
        this.fillArrayReadStringsLengthToBound(array, lengthString);
    }

    @Override
    public String[] fill(final int lengthArray,
                         @NotNull final Integer lengthString) {
        CheckerArray.check(lengthArray);
        CheckerString.check(lengthString, Capacity.UPPER.get());
        String[] strings = new String[lengthArray];
        this.fillArrayReadStringsLengthToBound(strings, lengthString);
        return strings;
    }

    @Override
    public void fill(@NotNull final Array<String> array,
                     @NotNull final Integer lowerLengthString,
                     @NotNull final Integer upperLengthString) {
        CheckerArray.check(array, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerLengthString,
                                        Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(upperLengthString,
                                        Capacity.UPPER.get());
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerLengthString,
                                                      upperLengthString);
        String[] strings = new String[array.size()];
        this.fillArrayReadStringsLengthFromLowerToUpper(strings,
                                                        lowerLengthString,
                                                        upperLengthString);
        array.setArray(strings);
    }

    @Override
    public void fill(@NotNull final String[] array,
                     @NotNull final Integer lowerLengthString,
                     @NotNull final Integer upperLengthString) {
        CheckerArray.check(array, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerLengthString,
                                        Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(upperLengthString,
                                        Capacity.UPPER.get());
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerLengthString,
                                                      upperLengthString);
        this.fillArrayReadStringsLengthFromLowerToUpper(array,
                                                        lowerLengthString,
                                                        upperLengthString);
    }

    @Override
    public String[] fill(final int lengthArray,
                         @NotNull final Integer lowerLengthString,
                         @NotNull final Integer upperLengthString) {
        CheckerArray.check(lengthArray);
        CheckerBoundNumber.checkInRange(lowerLengthString,
                                        Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(upperLengthString,
                                        Capacity.UPPER.get());
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerLengthString,
                                                      upperLengthString);
        String[] strings = new String[lengthArray];
        this.fillArrayReadStringsLengthFromLowerToUpper(strings,
                                                        lowerLengthString,
                                                        upperLengthString);
        return strings;
    }

    private void fillArrayReadStrings(final String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            if (super.getReader().hasNextLine()) {
                strings[i] = super.getReader().nextLine();
            }
        }
    }

    private void fillArrayReadStringsLengthToBound(final String[] strings,
                                                   final int lengthString) {
        this.fillArrayReadStringsLengthFromLowerToUpper(strings,
                                                        Capacity.LOWER.get(),
                                                        lengthString);
    }

    private void fillArrayReadStringsLengthFromLowerToUpper(
            final String[] strings, final int lowerLengthString,
            final int upperLengthString) {
        String strTmp;
        for (int i = 0; i < strings.length; i++) {
            if (super.getReader().hasNextLine()) {
                strTmp = super.getReader().nextLine();
                if (strTmp.length() >= lowerLengthString
                    && strTmp.length() <= upperLengthString) {
                    strings[i] = strTmp;
                } else {
                    throw new IllegalArgumentException(
                            new LengthOutOfRangeException(
                                    "String length out of the range from "
                                    + lowerLengthString + " to "
                                    + upperLengthString));
                }
            }
        }
    }

}
