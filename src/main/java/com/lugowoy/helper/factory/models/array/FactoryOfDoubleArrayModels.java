package com.lugowoy.helper.factory.models.array;

import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.arrays.ArrayOfDoubleNumbers;

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
 * A class that implements a factory contract to create objects of type Array.
 *  Objects of class Array will encapsulate an array of double numbers.
 * </p>
 */
public class FactoryOfDoubleArrayModels extends FactoryOfArrayModels<Double> {

    /**
     * <p>
     * Method for creating an object of Array<Double> type.
     * </p>
     */
    @Override
    public Array<Double> create() {
        return ArrayOfDoubleNumbers.getInstanceArrayOfDoubleNumbers();
    }

    /**
     * <p>
     * Method for the implementation of the creation of the object type Array<Double>.
     * </p>
     *
     * @param array An array of objects of types Double that will be encapsulated in an object of type Array<Double>.
     */
    @Override
    public Array<Double> create(Double[] array) {
        return ArrayOfDoubleNumbers.getInstanceArrayOfDoubleNumbers(array);
    }

    /**
     * <p>
     * Method for implementation of the creation of the object type Array<Double>.
     * </p>
     *
     * @param lengthArray The integer passed by the argument is the size of the array storing elements of type Double.
     */
    @Override
    public Array<Double> create(int lengthArray) {
        Array<Double> array = ArrayOfDoubleNumbers.getInstanceArrayOfDoubleNumbers(new Double[lengthArray]);
        array.setArray(lengthArray);
        return array;
    }

}
