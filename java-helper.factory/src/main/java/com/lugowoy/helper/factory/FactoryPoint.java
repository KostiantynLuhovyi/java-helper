package com.lugowoy.helper.factory;

import com.lugowoy.helper.factory.creator.CreatorPoint;
import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.0
 *
 * The class provides the functionality of the factory to create {@link Point} class objects.
 * The functionality for creating objects is implemented in the package classes com.lugowoy.helper.factory.creating .
 *
 * @see com.lugowoy.helper.factory.Factory
 */

public class FactoryPoint<T extends Number> extends Factory<Point<T>> {

    private FactoryPoint(CreatorPoint<T> creatorPoint) {
        super(creatorPoint);
    }

    /**
     * The method executes the creation of an object of {@link Point} class by calling the constructor of parameters.
     *
     * @param coordinateX The value of the coordinate X.
     * @param coordinateY The value of the coordinate Y.
     * @return Created object.
     *
     * @since 1.1
     */
    public Point<T> create(T coordinateX, T coordinateY) {
        return ((CreatorPoint<T>)super.getCreating()).create(coordinateX, coordinateY);
    }

    /**
     * A class method that creates and returns a new instance of the {@link FactoryPoint}.
     *
     * @return Object type {@link FactoryPoint}
     */
    public static <T extends Number> FactoryPoint<T> getFactoryPoint(CreatorPoint<T> creatorPoint) {
        return new FactoryPoint<>(creatorPoint);
    }

}
