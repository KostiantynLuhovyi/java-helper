package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.factory.creator.CreatorOfPointModels;
import com.lugowoy.helper.factory.models.points.FactoryOfPointsWithDoubleCoordinates;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.models.points.PointOfDoubleCoordinates;
import com.lugowoy.helper.reading.ReadingData;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 08-Dec-17.
 */
//todo Написать документацию. Провести полный рефакторинг.
public class FillingArrayUserInputDoubleCoordinatesOfPoints extends FillingArrayUserInputCoordinatesOfPoints<Double> {


    public FillingArrayUserInputDoubleCoordinatesOfPoints(ReadingData readingData) {
        super(readingData);
        super.setCreatorOfPointModels(new CreatorOfPointModels<>(new FactoryOfPointsWithDoubleCoordinates()));
    }

    @Override
    public Point<Double>[] fill(Point<Double>[] points) {
        return Arrays.stream(CREATOR_OF_ARRAY_DOUBLE_COORDINATES_OF_POINTS.create(points).getArray())
                     .map(point -> super.getCreatorOfPointModels().create(super.getReader().readDouble(),
                                                                          super.getReader().readDouble()))
                     .toArray(PointOfDoubleCoordinates[]::new);
    }

    @Override
    public Point<Double>[] fill(int lengthArray) {
        return Arrays.stream(CREATOR_OF_ARRAY_DOUBLE_COORDINATES_OF_POINTS.create(lengthArray).getArray())
                     .map(point -> super.getCreatorOfPointModels().create(super.getReader().readDouble(),
                                                                          super.getReader().readDouble()))
                     .toArray(PointOfDoubleCoordinates[]::new);
    }

}
