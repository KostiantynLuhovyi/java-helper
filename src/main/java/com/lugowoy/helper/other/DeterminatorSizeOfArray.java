package com.lugowoy.helper.other;

import com.lugowoy.helper.reading.Reader;
import com.lugowoy.helper.reading.ReadingDataUserInputInConsole;

/** Created by Konstantin Lugowoy on 02.08.2017. */

public class DeterminatorSizeOfArray {

    private static final Reader READER = new Reader(new ReadingDataUserInputInConsole());

    public static int determineSizeOfArray() {
        int sizeArray;
        System.out.println("Enter size of the array : ");
        while (true) {
            sizeArray = READER.readInt();
            if (sizeArray > 0) {
                break;
            } else {
                System.out.println("Incorrect size of the array. Re-enter : ");
            }
        }
        return sizeArray;
    }

    public static int determineSizeOfArray(int boundSizeOfArray) {
        int sizeArray;
        System.out.println("Enter size of the array : ");
        while (true) {
            sizeArray = READER.readInt();
            if ((sizeArray > 0) && (sizeArray <= boundSizeOfArray)) {
                break;
            } else {
                System.out.println("Incorrect size of the array. Re-enter : ");
            }
        }
        return sizeArray;
    }

    public static int determineSizeOfArray(int minBoundSizeOfArray, int maxBoundSizeOfArray) {
        int sizeArray;
        System.out.println("Enter size of the array : ");
        while (true) {
            sizeArray = READER.readInt();
            if ((sizeArray > minBoundSizeOfArray) && (sizeArray <= maxBoundSizeOfArray)) {
                break;
            } else {
                System.out.println("Incorrect size of the array. Re-enter : ");
            }
        }
        return sizeArray;
    }

}
