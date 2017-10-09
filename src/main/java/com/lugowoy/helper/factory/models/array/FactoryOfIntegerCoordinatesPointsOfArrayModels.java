package com.lugowoy.helper.factory.models.array;

import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.arrays.ArrayOfIntegerCoordinatesPoints;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.models.points.PointOfIntegerCoordinates;

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
 * @see com.lugowoy.helper.factory.models.array.FactoryOfPointsOfArrayModels
 *
 * <p>
 * A class that implements a contract for a factory to create objects of type Array<Point<Integer>>.
 * </p>
 */
public class FactoryOfIntegerCoordinatesPointsOfArrayModels extends FactoryOfPointsOfArrayModels<Integer> {

    /**
     * <p>
     * Method for creating an object of a type <Point<Integer>>.
     * </p>
     */
    @Override
    public Array<Point<Integer>> create() {
        return ArrayOfIntegerCoordinatesPoints.getInstanceArrayOfIntegerCoordinatesPoints();
    }

    /**
     * <p>
     * Method for the implementation of the creation of the object type Array<Point<Integer>>.
     * </p>
     *
     * @param array An array of objects of types <Point<Integer>> that will be encapsulated in an object of type Array<Point<Integer>>.
     */
    @Override
    public Array<Point<Integer>> create(Point<Integer>[] array) {
        return ArrayOfIntegerCoordinatesPoints.getInstanceArrayOfIntegerCoordinatesPoints(array);
    }

    /**
     * <p>
     * Method for implementation of the creation of the object type Array<Point<Integer>>.
     * </p>
     *
     * @param lengthArray The integer passed by the argument is the size of the array storing elements of type <Point<Integer>>.
     */
    @Override
    public Array<Point<Integer>> create(int lengthArray) {
        return ArrayOfIntegerCoordinatesPoints.getInstanceArrayOfIntegerCoordinatesPoints(new PointOfIntegerCoordinates[lengthArray]);
    }

}
