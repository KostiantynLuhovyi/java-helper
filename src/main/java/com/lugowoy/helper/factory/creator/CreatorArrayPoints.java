package com.lugowoy.helper.factory.creator;

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
 * The class implements a contract that creates objects of the {@link ArrayOfPoints} type encapsulating an array of objects {@link Point}.
 * </p>
 *
 * @see com.lugowoy.helper.factory.creator.Creator
 * @see com.lugowoy.helper.factory.creator.CreatorArray
 * @see com.lugowoy.helper.factory.creator.Creating
 * @see com.lugowoy.helper.factory.creator.CreatingArray
 *
 * @param <T> The type an array of objects {@link Point} encapsulated in an {@link ArrayOfPoints} object.
 */

public class CreatorArrayPoints<T extends Number> extends CreatorArray<Point<T>> {

    /**
     * <p>
     * The method creates an object of the {@link ArrayOfPoints} type that calls the default constructor.
     * </p>
     *
     * @see com.lugowoy.helper.factory.creator.Creator
     * @see com.lugowoy.helper.factory.creator.CreatorArray
     * @see com.lugowoy.helper.factory.creator.Creating
     *
     * @see com.lugowoy.helper.models.arrays.Array
     * @see com.lugowoy.helper.models.arrays.ArrayOfPoints
     *
     * @return The created object of type {@link ArrayOfPoints}.
     *
     * @since 1.0
     */
    @Override
    public Array<Point<T>> create() {
        return new ArrayOfPoints<>();
    }

    /**
     * <p>
     * The method creates an object of the {@link ArrayOfPoints} type that calls the constructor with parameter {@link ArrayOfPoints#ArrayOfPoints(Point[])}.
     * </p>
     *
     * @see com.lugowoy.helper.factory.creator.CreatorArray
     * @see com.lugowoy.helper.factory.creator.CreatingArray
     *
     * @see com.lugowoy.helper.models.arrays.Array
     * @see com.lugowoy.helper.models.arrays.ArrayOfPoints
     *
     * @param tArray An array of objects {@link Point} that will be encapsulate in the created class object {@link ArrayOfPoints}.
     *
     * @return The created object of type {@link ArrayOfPoints}.
     *
     * @since 1.0
     */
    @Override
    public Array<Point<T>> create(Point<T>[] tArray) {
        return new ArrayOfPoints<>(tArray);
    }

    /**
     * <p>
     * The method creates an object of the {@link ArrayOfPoints} type that calls the constructor with parameter {@link ArrayOfPoints#ArrayOfPoints(int)}.
     * </p>
     *
     * @see com.lugowoy.helper.factory.creator.CreatorArray
     * @see com.lugowoy.helper.factory.creator.CreatingArray
     *
     * @see com.lugowoy.helper.models.arrays.Array
     * @see com.lugowoy.helper.models.arrays.ArrayOfPoints
     *
     * @param lengthArray Length of array of objects {@link Point} that will be encapsulate in the created class object {@link ArrayOfPoints}.
     *
     * @return The created object {@link ArrayOfPoints} encapsulates an array of the length of the passed parameter.
     *
     * @since 1.0
     */
    @Override
    public Array<Point<T>> create(int lengthArray) {
        return new ArrayOfPoints<>(lengthArray);
    }

}
