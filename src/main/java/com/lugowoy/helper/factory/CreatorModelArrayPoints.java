package com.lugowoy.helper.factory;

import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.arrays.ArrayOfPoints;
import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 02-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * <p>
 * A class that implements a contract for a functional that creates objects of type ArrayOfPoints<T> .
 * </p>
 *
 * @see com.lugowoy.helper.factory.Creator
 * @see com.lugowoy.helper.factory.CreatorModel
 * @see com.lugowoy.helper.factory.CreatorModelArray
 *
 * @param <T> The type of coordinates that encapsulates a Point<T> class object.
 */

public class CreatorModelArrayPoints<T extends Number> extends CreatorModelArray<Point<T>> {

    /**
     * <p>
     * The method creates an object of the ArrayOfPoints<T> type that calls the default constructor.
     * </p>
     * @since 1.0
     *
     * @see com.lugowoy.helper.models.Model
     * @see com.lugowoy.helper.models.arrays.Array
     * @see com.lugowoy.helper.models.arrays.ArrayOfPoints
     *
     * @return The created object of type ArrayOfPoints<T> .
     */
    @Override
    public Array<Point<T>> create() {
        return new ArrayOfPoints<>();
    }

    /**
     * <p>
     * The method creates an object of type ArrayOfPoints<T> calling the constructor with a parameter
     *  and passing it the parameter passed to the method.
     * <p>
     * The parameter is required to initialize the data encapsulated by the object of the class ArrayOfPoints<T> .
     * </p>
     * @since 1.0
     *
     * @see com.lugowoy.helper.models.Model
     * @see com.lugowoy.helper.models.arrays.Array
     * @see com.lugowoy.helper.models.arrays.ArrayOfPoints
     *
     * @return The created object of type ArrayOfPoints<T> .
     */
    @Override
    public Array<Point<T>> create(Point<T>[] tArray) {
        return new ArrayOfPoints<>(tArray);
    }

    /**
     * <p>
     * The method creates an object of type ArrayOfPoints<T> calling the constructor with a parameter
     *  and passing it the parameter passed to the method.
     * <p>
     * The parameter is required to initialize the data encapsulated by the object of the class ArrayOfPoints<T> .
     * </p>
     * @since 1.0
     *
     * @see com.lugowoy.helper.models.Model
     * @see com.lugowoy.helper.models.arrays.Array
     * @see com.lugowoy.helper.models.arrays.ArrayOfPoints
     *
     * @return The created object of type ArrayOfPoints<T> .
     */
    @Override
    public Array<Point<T>> create(int lengthArray) {
        return null;
    }

}
