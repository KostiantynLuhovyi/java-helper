package com.lugowoy.helper.filling;

/**
 * Created by Konstantin Lugowoy on 27.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 17.12.2017
 * <p>
 * A class that is a certain container that encapsulating and uses an implementation of the functional that fills the object with data.
 * </p>
 * @param <T> Type of data that is filling the objects.
 */

public abstract class Filler<T> implements Fillable<T> {

    /**
     * <p>
     * An object encapsulating the implementation of the functionality to perform the filling of the objects with data.
     * </p>
     * @see com.lugowoy.helper.filling.Filling
     */
    protected final Filling<T> filling;

    /**
     * <p>
     * Creates an object initializing its specific implementation of the functionality to filling the objects with data.
     * </p>
     * @param filling An object encapsulating the implementation of filling the objects with data.
     */
    public Filler(final Filling<T> filling) {
        this.filling = filling;
    }

}
