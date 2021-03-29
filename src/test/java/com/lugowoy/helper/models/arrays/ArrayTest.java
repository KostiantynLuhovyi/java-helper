package com.lugowoy.helper.models.arrays;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegers;
import com.lugowoy.helper.filling.array.strings.FillingArrayRandomStrings;
import com.lugowoy.helper.utils.HelperArrayFiller;
import com.lugowoy.helper.utils.HelperFillerValues;
import com.lugowoy.helper.utils.RandomNumber;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;

public class ArrayTest {

    private HelperArrayFiller fillerArray = new HelperArrayFiller();

    @Test
    public void testReturnSortValue() {
        Array<String> array = null;
        try {
            array = new Array<>(fillerArray.getArray(new FillingArrayRandomStrings(new FileInputStream("D:\\Projects\\java-helper\\src\\main\\resources\\characters\\english.txt")), 20, 0, 100));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(array + ", size: " + array.size());
        array.sort(String::compareTo);
        System.out.println();
        System.out.println(array);
    }

    @Test
    public void testReturnSubList() {
        Array<Integer> array = new Array<>(fillerArray.getArray(
                new FillingArrayRandomIntegers(),
                new RandomNumber().generateInt(20), HelperFillerValues.INT_ZERO,
                HelperFillerValues.INT_POSITIVE_HUNDRED));
        System.out.println(array);
        array.subList(0, array.size() - 1);
        System.out.println();
        System.out.println(array);
        List<Integer> integerList = array.subList(0, array.size() - 1);
        System.out.println("Integer list : " + integerList);
    }

}