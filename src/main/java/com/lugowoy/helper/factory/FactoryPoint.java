package com.lugowoy.helper.factory;

import com.lugowoy.helper.factory.creator.CreatorPoint;
import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * <p>
 * The class provides the functionality of the factory to create {@link Point} class objects.
 * The functionality for creating objects is implemented in the package classes com.lugowoy.helper.factory.creating .
 * </p>
 *
 * @see com.lugowoy.helper.factory.creator
 */

public class FactoryPoint<T extends Number> extends Factory<Point<T>> {

    private FactoryPoint(CreatorPoint<T> creatorPoint) {
        super(creatorPoint);
    }

    /**
     * <p>
     * A class method that creates and returns a new instance of the {@link FactoryPoint}.
     * </p>
     * @since 1.0
     *
     * @return Object type {@link FactoryPoint}
     */
    public static <T extends Number> FactoryPoint<T> getFactoryPoint(CreatorPoint<T> creatorPoint) {
        return new FactoryPoint<>(creatorPoint);
    }

}
