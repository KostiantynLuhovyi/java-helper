package com.lugowoy.helper.filling;

/**
 * Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 *
 * The class that is a container that encapsulates a specific implementation of a contract declared in the {@link Filling} interface
 *  and delegates to it an obligation to perform functionality to fill a particular object or data structure with data.
 * <p> All an objects of the classes that implement the contract of the {@link Filling} interface can be encapsulated
 *  and involved in the functionality.
 *
 * @see com.lugowoy.helper.filling.Filling
 *
 * @param <T> The type of objects that are filled with different data.
 * */

public class Filler<T> implements Filling<T> {

    private Filling<T> filling;

    /**
     * Default constructor.
     * The presence of this is absolutely not necessary.
     * Its presence is caused by the need to add more extended constructor variants to the inheritor of this class.
     * */
    protected Filler() {
    }

    /**
     * Constructor to create a new {@link Filler} and initializes the object encapsulated in this class to perform the functionality.
     *
     * @param filling An object that implements the {@link Filling} interface contract to fill an object or data structure.
     * */
    protected Filler(Filling<T> filling) {
        this.filling = filling;
    }

    /**
     * Fills an object or data structure with data.
     *
     * <p>The execution of this method is delegated to the object that contains the implementation of the {@link Filling} interface contract
     *  and is encapsulated in the object of this class.
     *
     * @param t The object or data structure to be filled with data.
     * @return The object or data structure filled with data.
     * */
    public T fill(T t) {
        return this.filling.fill(t);
    }

    /**
     * Returns an object encapsulated in an object of this class and implements the contract declared in the {@link Filling} interface.
     *
     * @return The object is encapsulated in an object of this class and implements the contract declared in the {@link Filling} interface.
     * */
    protected Filling<T> getFilling() {
        return filling;
    }

    /**
     * Creates a new object of {@link Filler} class by calling a single constructor with a parameter
     *  for initialization the object encapsulated in this class to perform the functionality.
     *
     * @param filling The object that implements the {@link Filling} interface contract to fill an object or data structure.
     * @return The created object of this class.
     * */
    public static <T> Filler<T> getFiller(Filling<T> filling) {
        return new Filler<>(filling);
    }

}
