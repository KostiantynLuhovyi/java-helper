package com.lugowoy.helper.factory.models.array;

import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;

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
 * An abstract class that overrides the methods declared in interfaces to implement the creation of type Array object.
 * </p>
 */
public abstract class FactoryOfPointsOfArrayModels<T extends Number> extends FactoryOfArrayModels<Point<T>> {


    /**
     * <p>
     * Method for creating an object of a type Array<Point<T>>.
     * </p>
     */
    @Override
    public abstract Array<Point<T>> create();

    /**
     * <p>
     * Method for the implementation of the creation of the object type Array<Point<T>>.
     * </p>
     *
     * @param array An array of objects of types <Point<T>> that will be encapsulated in an object of type Array<Point<T>>.
     */
    @Override
    public abstract Array<Point<T>> create(Point<T>[] array);

    /**
     * <p>
     * Method for implementation of the creation of the object type Array<Point<T>>.
     * </p>
     *
     * @param length The integer passed by the argument is the size of the array storing elements of type <Point<T>>.
     */
    @Override
    public abstract Array<Point<T>> create(int length);

}
