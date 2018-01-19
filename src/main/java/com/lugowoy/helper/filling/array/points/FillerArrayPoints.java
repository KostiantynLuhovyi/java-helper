package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.filling.array.FillerArray;
import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 16-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.0
 *
 * <p>
 *
 * </p>
 *
 * @see com.lugowoy.helper.filling.Filler
 * @see com.lugowoy.helper.filling.array.FillerArray
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.points.FillingArrayPoints
 *
 * @param <T>
 */

public class FillerArrayPoints<T extends Number> extends FillerArray<Point<T>> implements FillingArray<Point<T>>, FillingArrayPoints<T> {

    private FillingArrayPoints<T> fillingArrayPoints;

    /**
     * <p></p>
     *
     * @param fillingArray
     *
     * @since 1.0
     */
    private FillerArrayPoints(FillingArray<Point<T>> fillingArray) {
        super(fillingArray);
    }

    /**
     * <p></p>
     *
     * @param fillingArrayPoints
     *
     * @since 1.0
     */
    private FillerArrayPoints(FillingArrayPoints<T> fillingArrayPoints) {
        this.fillingArrayPoints = fillingArrayPoints;
    }

    /**
     * <p></p>
     *
     * @param array
     *
     * @since 1.0
     */
    @Override
    public Point<T>[] fill(T[] array) {
        return this.fillingArrayPoints.fill(array);
    }

    /**
     * <p></p>
     *
     * @param fillingArray
     *
     * @return
     *
     * @since 1.0
     */
    public static <T extends Number> FillerArrayPoints<T> getFillerArrayPoints(FillingArray<Point<T>> fillingArray) {
        return new FillerArrayPoints<T>(fillingArray);
    }

    /**
     * <p></p>
     *
     * @param fillingArrayPoints
     *
     * @return
     *
     * @since 1.0
     */
    public static <T extends Number> FillerArrayPoints<T> getFillerArrayPoints(FillingArrayPoints<T> fillingArrayPoints) {
        return new FillerArrayPoints<T>(fillingArrayPoints);
    }

}
