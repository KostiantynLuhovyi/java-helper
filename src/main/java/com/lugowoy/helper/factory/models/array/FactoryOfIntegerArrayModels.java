package com.lugowoy.helper.factory.models.array;

import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.arrays.ArrayOfIntegerNumbers;

/**
 * Created by Konstantin Lugowoy on 01.08.2017.
 *
 * @author Konstantin Lugowoy
 * @see com.lugowoy.helper.factory.Factorable
 * @see com.lugowoy.helper.factory.FactorableOfModels
 * @see com.lugowoy.helper.factory.FactorableOfArrayModels
 * @see com.lugowoy.helper.factory.Factory
 * @see com.lugowoy.helper.factory.models.FactoryOfModels
 * @see com.lugowoy.helper.factory.models.array.FactoryOfArrayModels
 *
 * <p>
 * A class that implements a contract for a factory to create objects of type Array<Integer>.
 *  Objects of class Array will encapsulate an array of integer numbers.
 * </p>
 */
public class FactoryOfIntegerArrayModels extends FactoryOfArrayModels<Integer> {

    /**
     * <p>
     * Method for creating an object of Array<Integer> type.
     * </p>
     */
    @Override
    public Array<Integer> create() {
        return ArrayOfIntegerNumbers.getInstanceArrayOfIntegerNumbers();
    }

    /**
     * <p>
     * Method for the implementation of the creation of the object type Array<Integer>.
     * </p>
     *
     * @param array An array of objects of types Integer that will be encapsulated in an object of type Array<Integer>.
     */
    @Override
    public Array<Integer> create(Integer[] array) {
        return ArrayOfIntegerNumbers.getInstanceArrayOfIntegerNumbers(array);
    }

    /**
     * <p>
     * Method for implementation of the creation of the object type Array<Integer>.
     * </p>
     *
     * @param lengthArray The integer passed by the argument is the size of the array storing elements of type Integer.
     */
    @Override
    public Array<Integer> create(int lengthArray) {
        Array<Integer> array = ArrayOfIntegerNumbers.getInstanceArrayOfIntegerNumbers(new Integer[lengthArray]);
        array.setArray(lengthArray);
        return array;
    }

}
