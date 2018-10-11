package com.lugowoy.helper.factory.creator;

/**
 * The class implements the creation of objects based on the class {@link Class}.
 * <p>Created by Konstantin Lugowoy on 04-Jan-18.
 *
 * @param <T> Type of objects to create.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @see com.lugowoy.helper.factory.creator.Creator
 * @see com.lugowoy.helper.factory.creator.Creating
 * @since 1.0
 */
public class CreatorUnknown<T> extends Creator<T> {

    private Class<T> clazz;

    /**
     * Constructor with a parameter is used to create an object based on a type parameter {@link Class}.
     *
     * @param clazz An object of the class Class<T> on the basis of which the object will be created.
     */
    public CreatorUnknown(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * The method creates an object using a class {@link Class} object encapsulated in this class.
     *
     * @return The created object an object using a class {@link Class}.
     */
    @Override
    public T create() {
        T t = null;
        try {
            t = this.clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }

}
