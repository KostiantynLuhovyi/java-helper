package com.lugowoy.helper.filling;

import org.jetbrains.annotations.NotNull;

import java.io.Reader;
import java.util.Objects;
import java.util.Scanner;

/**
 * The abstract class encapsulates and provides functionality to fill objects or
 * storages (data structures) with data read from some source. The data reading
 * for filling uses objects of {@link Reader} classes (or subclasses).
 * <p> Created by Konstantin Lugowoy on 05.10.2018.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 */
//TODO review documentation
public abstract class FillingReadValues {

    private Scanner scanner;

    /**
     * Constructs a new object, initializing the implementation of reading data
     * to fill. The implementation of data reading provided by class objects
     * {@link Reader} or its subclasses.
     *
     * @param reader the object implementation of reading data to fill.
     */
    protected FillingReadValues(@NotNull final Reader reader) {
        Objects.requireNonNull(reader, "Reader is null.");
        this.scanner = new Scanner(reader);
    }

    /**
     * Gets an object encapsulated in an object of this class and implements of
     * reading data to fill.
     *
     * @return the object implementation of reading data to fill.
     */
    protected Scanner getReader() {
        return this.scanner;
    }

    /**
     * Sets the implementation of reading data to fill. The implementation of
     * data reading provided by class objects {@link Reader} or its subclasses.
     *
     * @param reader the object implementation of reading data to fill.
     */
    public void setReader(@NotNull final Reader reader) {
        Objects.requireNonNull(reader, "Reader is null.");
        this.scanner = new Scanner(reader);
    }

}
