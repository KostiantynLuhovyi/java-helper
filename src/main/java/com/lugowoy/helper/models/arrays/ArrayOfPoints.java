package com.lugowoy.helper.models.arrays;

import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 01.08.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 20.12.2017
 * <p>
 *     A class representing an implementation for using a non-expandable array model whose elements are points.
 * </p>
 * @see com.lugowoy.helper.models.Model
 * @see com.lugowoy.helper.models.arrays.Array
 * @see java.io.Serializable
 * @see java.lang.Cloneable
 * @param <T> The type of objects that initialize the coordinates of a point.
 */

public class ArrayOfPoints<T extends Number> extends Array<Point<T>> {

    /**
     * <p>
     *     The default constructor that initializes the created object with an array of the points of default size.
     *     Array elements are null.
     * </p>
     */
    private ArrayOfPoints() {
        super();
    }

    /**
     * <p>
     *     The constructor that initializes the created object with an array of the points of passed by an argument.
     *
     *     If the array of the numbers passed by the argument is null,
     *     the created object will initialize the array with the default size.
     *     In this case, the elements of the array are null.
     * </p>
     */
    private ArrayOfPoints(Point<T>[] array) {
        super(array);
    }

    @SuppressWarnings("unchecked")
    @Override
    public ArrayOfPoints<T> clone() throws CloneNotSupportedException {
        ArrayOfPoints<T> arrayOfPoints = (ArrayOfPoints<T>) super.clone();
        arrayOfPoints.setArray(super.getArray());
        return arrayOfPoints;
    }

    /**
     * <p>
     *      Sets the value for the attribute of the array encapsulated in this object,
     *      creating a new array with the size of the value passed by the argument.
     *
     *      If the value passed by the argument is equal to or less than 0,
     *      then the attribute is initialized by an array of the default size.
     *
     *      Array elements are null.
     * </p>
     * @param sizeOfArray The size of the array to create and initialize the attribute of the object.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void setArray(int sizeOfArray) {
        if (sizeOfArray > 0) {
            super.setArray((Point<T>[]) new Object[sizeOfArray]);
        } else {
            super.setArray((Point<T>[]) new Object[DEFAULT_SIZE_OF_ARRAY]);
        }
    }

}
