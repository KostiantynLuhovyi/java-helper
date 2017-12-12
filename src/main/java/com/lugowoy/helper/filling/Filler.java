package com.lugowoy.helper.filling;

/**
 * Created by Konstantin Lugowoy on 27.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 27.07.2017
 * <p>
 * A class that is a certain container that receives and uses an implementation of the functional
 *  that fills the object with data.
 * </p>
 * @param <T> Type of object that is filling with data.
 */
//todo Проверить документацию и корректность класса.
public abstract class Filler<T> implements Fillable<T> {

    private Filling<T> filling;

    /**
     * <p>
     * Constructor with parameter.
     * The parameter accepts an object encapsulating the implementation of the interface for filling the object with data.
     * </p>
     */
    public Filler(Filling<T> filling) {
        this.filling = filling;
    }

    /**
     * <p>
     * The method returns a reference to the object encapsulating the implementation of the interface
     *  for filling the object with data.
     * </p>
     * @return A reference to the object encapsulating the implementation of the interface of filling the object with data.
     */
    public Filling<T> getFilling() {
        return filling;
    }

}