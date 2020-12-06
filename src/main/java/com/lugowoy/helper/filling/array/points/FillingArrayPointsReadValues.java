package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.filling.array.FillingArrayReadValues;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.points.Point;
import org.jetbrains.annotations.NotNull;

import java.io.Reader;

/**
 * The class is the root of the class hierarchy that implements the contract
 * declared in the {@link FillingArrayPoints} interface of the filling of
 * objects of {@link Array} class and classical arrays with an object of the
 * {@link Point} class with numeric coordinates using the data read by the
 * object of the class {@link Reader} encapsulated in this class.
 * <p>Created by Konstantin Lugowoy on 27-Jan-18.
 *
 * @author Konsytantin Lugowoy
 * @version 1.4
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.points.FillingArrayPoints
 */
//TODO review documentation
public abstract class FillingArrayPointsReadValues<T extends Point<V>, V extends Number>
        extends FillingArrayReadValues implements FillingArrayPoints<T, V> {

    /**
     * Constructs a new heir class object, initializing an object of {@link
     * Reader} class encapsulated in that class to read the data to be fill
     * array.
     *
     * @param reader The object of {@link Reader} class for initializing an
     * object {@link Reader} class encapsulated in this class to read data to
     * fill array.
     */
    public FillingArrayPointsReadValues(@NotNull final Reader reader) {
        super(reader);
    }

}
