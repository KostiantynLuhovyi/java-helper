package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.factory.creator.CreatorOfPointModels;
import com.lugowoy.helper.factory.models.points.FactoryOfPointsWithDoubleCoordinates;
import com.lugowoy.helper.generator.GeneratorDataRandomDouble;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.models.points.PointOfDoubleCoordinates;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 08-Dec-17.
 */
//todo Написать документацию. Провести полный рефакторинг.
public class FillingArrayRandomDoubleCoordinatesOfPoints extends FillingArrayPoints<Double> {

    private static final double MIN_BOUND = -200.0;
    private static final double MAX_BOUND = 200.0;

    public FillingArrayRandomDoubleCoordinatesOfPoints() {
        super();
        super.setCreatorOfPointModels(new CreatorOfPointModels<>(new FactoryOfPointsWithDoubleCoordinates()));
    }

    @Override
    public Point<Double>[] fill(Point<Double>[] points) {
        return Arrays.stream(CREATOR_OF_ARRAY_DOUBLE_COORDINATES_OF_POINTS.create(points).getArray())
                     .map(point -> super.getCreatorOfPointModels().create(GeneratorDataRandomDouble.generateDouble(MIN_BOUND, MAX_BOUND),
                                                                          GeneratorDataRandomDouble.generateDouble(MIN_BOUND, MAX_BOUND)))
                     .toArray(PointOfDoubleCoordinates[]::new);
    }

    @Override
    public Point<Double>[] fill(int lengthArray) {
        return Arrays.stream(CREATOR_OF_ARRAY_DOUBLE_COORDINATES_OF_POINTS.create(lengthArray).getArray())
                     .map(point -> super.getCreatorOfPointModels().create(GeneratorDataRandomDouble.generateDouble(),
                                                                          GeneratorDataRandomDouble.generateDouble()))
                     .toArray(PointOfDoubleCoordinates[]::new);
    }

}
