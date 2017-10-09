package com.lugowoy.helper.models;

import java.io.Serializable;

/**
 * Created by Konstantin Lugowoy on 31.05.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.1
 *
 * @see Serializable
 * @see Cloneable
 * <p>
 * A class that is the root of an inheritance hierarchy for constructing all possible classes needed to solve different tasks
 * </p>
 */
public abstract class Model implements Cloneable, Serializable {

    /**
     * <p>
     * The default constructor for initializing objects.
     * </p>
     * */
    public Model() {
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
