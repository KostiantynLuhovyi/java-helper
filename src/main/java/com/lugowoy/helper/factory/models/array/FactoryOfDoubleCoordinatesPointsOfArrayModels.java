package com.lugowoy.helper.factory.models.array;

import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.arrays.ArrayOfDoubleCoordinatesPoints;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.models.points.PointOfDoubleCoordinates;

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
 * A class that implements a contract for a factory to create objects of type Array<Point<Double>>.
 * </p>
 */
public class FactoryOfDoubleCoordinatesPointsOfArrayModels extends FactoryOfPointsOfArrayModels<Double> {

    /**
     * <p>
     * Method for creating an object of a type <Point<Double>>.
     * </p>
     */
    @Override
    public Array<Point<Double>> create() {
        return ArrayOfDoubleCoordinatesPoints.getInstanceArrayOfDoubleCoordinatesPoints();
    }

    /**
     * <p>
     * Method for the implementation of the creation of the object type Array<Point<Double>>.
     * </p>
     *
     * @param array An array of objects of types <Point<Double>> that will be encapsulated in an object of type Array<Point<Double>>.
     */
    @Override
    public Array<Point<Double>> create(Point<Double>[] array) {
        return ArrayOfDoubleCoordinatesPoints.getInstanceArrayOfDoubleCoordinatesPoints(array);
    }

    /**
     * <p>
     * Method for implementation of the creation of the object type Array<Point<Double>>.
     * </p>
     *
     * @param lengthArray The integer passed by the argument is the size of the array storing elements of type <Point<Double>>.
     */
    @Override
    public Array<Point<Double>> create(int lengthArray) {
        Array<Point<Double>> array = ArrayOfDoubleCoordinatesPoints.getInstanceArrayOfDoubleCoordinatesPoints();
        array.setArray(new PointOfDoubleCoordinates[lengthArray]);
        return array;
    }

}
