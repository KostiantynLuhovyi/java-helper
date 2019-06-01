package com.lugowoy.helper.filling;

/**
 * This class is a container (delegates the execution of functionality) for the implementation of the contract declared
 * in the {@link Filling} interface.
 * The class is the root of the hierarchy that represents this functionality.
 * <p>The methods of this class are delegated to the execution of a specific implementation of the contract declared
 * in the {@link Filling} interface transferred during the creation of an instance of this class.
 * <p>Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @param <T> Type of data elements and storage(data structure) or the object to fill.
 * @author Konstantin Lugowoy
 * @version 1.3
 * @see com.lugowoy.helper.filling.Filling
 */
public class Filler<T> {

    private Filling<T> filling;

    /**
     * Constructs a new object by initializing it with a concrete implementation of the contract declared
     * in the {@link Filling} interface.
     *
     * @param filling Object realizing the contract declared in the {@link Filling} interface.
     */
    protected Filler(Filling<T> filling) {
        this.filling = filling;
    }

    /**
     * Fills the object or storage(data storage) with data.
     *
     * @param t The object or storage(data structure) to be filled.
     */
    public void fill(T t) {
        this.filling.fill(t);
    }

    /**
     * Get object provides functionality and contract implementation declared in the {@link Filling} interface.
     *
     * @return The object provides functionality and implementation.
     */
    protected Filling<T> getFilling() {
        return filling;
    }

    /**
     * Creates a new {@link Filler} class object by invoking the sole constructor of this class.
     *
     * @param filling The object realizing the contract declared in the {@link Filling} interface.
     * @return Created object of this class.
     */
    public static <T> Filler<T> getFiller(Filling<T> filling) {
        return new Filler<>(filling);
    }

}
