package com.lugowoy.helper.converting;

/**
 * Created by Konstantin on 29-Jan-17.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 08.12.2017
 * <p>
 * A class that is a kind of container that encapsulates a function for performing data conversion in a concrete object.
 * </p>
 * @param <T> The type of object whose data will be converted.
 */

public class ConvertingData<T> {

    private Converting<T> converting;

    /**
     * <p>
     * Constructor with parameter.
     * The parameter {@link ConvertingData#converting} provides the implementation of the function to perform the conversion.
     * </p>
     * @see com.lugowoy.helper.converting.Converting
     * @param converting The parameter provides the implementation of the function to perform the conversion.
     */
    public ConvertingData(Converting<T> converting) {
        this.converting = converting;
    }

    /**
     * <p>
     * A method that performs the conversion of object data passed by a parameter to a method.
     * The method delegates the execution of the function which the object was initialized upon creation.
     * </p>
     * @see com.lugowoy.helper.converting.Converting
     * @param t The object passed by the parameter whose data is being converted.
     * */
    public void convert(T t) {
        converting.convert(t);
    }

}
