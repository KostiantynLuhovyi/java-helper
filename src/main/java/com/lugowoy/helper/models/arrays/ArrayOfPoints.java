package com.lugowoy.helper.models.arrays;

import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.other.DeepCloning;

/**
 * Created by Konstantin Lugowoy on 01.08.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * This class is a model of a dynamic array for storing points.
 *
 * @see com.lugowoy.helper.models.Model
 * @see com.lugowoy.helper.models.arrays.Array
 * @see java.io.Serializable
 * @see java.lang.Cloneable
 *
 * @param <T> The type of objects that initialize the coordinates of a point.
 */

public class ArrayOfPoints<T extends Number> extends Array<Point<T>> {

    /**
     * The default constructor that initializes the created object with an array of the points of default length.
     * <p>Array elements are null.
     *
     * @since 1.0
     */
    public ArrayOfPoints() {
        super();
    }

    /**
     * The constructor that initializes the created object with an array of the points of passed by an parameter.
     * <p> If the array of the points passed by the parameter is null, the created object will initialize
     *  the array with the default length.
     * In this case, the elements of the array are null.
     *
     * @since 1.0
     */
    public ArrayOfPoints(Point<T>[] array) {
        super(array);
    }

    /**
     * The constructor that initializes the created object with an array whose length is equal to the value passed to the parameter.
     * <p> If the length of array value passed by the parameter is equal to or less the 0,
     *  the created object will initialize the array with the default length.
     * <p> Array elements are null.
     *
     * @param lengthArray The length of the array to initialize the object to be created.
     *
     * @since 1.0
     */
    public ArrayOfPoints(int lengthArray) {
        super(lengthArray);
    }

    @SuppressWarnings("unchecked") //Type safety when casting.
    @Override
    public ArrayOfPoints<T> clone() {
        ArrayOfPoints<T> arrayOfPoints = new ArrayOfPoints<>();
        try {
            arrayOfPoints = (ArrayOfPoints<T>) super.clone();
            arrayOfPoints = DeepCloning.CLONER.deepClone(this);
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return arrayOfPoints;
    }

}
