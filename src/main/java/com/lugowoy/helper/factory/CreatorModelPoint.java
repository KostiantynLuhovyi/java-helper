package com.lugowoy.helper.factory;

import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 02-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * <p>
 * A class that implements a contract for a functional that creates objects of type Point<T> .
 * </p>
 *
 * @see com.lugowoy.helper.factory.Creator
 * @see com.lugowoy.helper.factory.CreatorModel
 *
 * @param <T> The type of coordinates with which the created object of the class Point<T> is initialized.
 */

public class CreatorModelPoint<T extends Number> extends CreatorModel {

    /**
     * <p>
     * The method creates an object of the Point<T> type that calls the default constructor.
     * </p>
     * @since 1.0
     *
     * @see com.lugowoy.helper.models.Model
     * @see com.lugowoy.helper.models.points.Point
     *
     * @return The created object of type Point<T> .
     */
    @Override
    public Point<T> create() {
        return new Point<>();
    }

    /**
     * <p>
     * The method creates an object of type Point<T> calling the constructor with a parameters
     *  and passing it the parameters passed to the method.
     * <p>
     * The parameters is required to initialize the data encapsulated by the object of the class Point<T> .
     * </p>
     * @since 1.0
     *
     * @see com.lugowoy.helper.models.Model
     * @see com.lugowoy.helper.models.points.Point
     *
     * @return The created object of type Point<T> .
     */
    public Point<T> create(T coordinateX, T coordinateY) {
        return new Point<>(coordinateX, coordinateY);
    }

}
