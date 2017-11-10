package com.lugowoy.helper.reading;

import com.lugowoy.helper.reading.readable.Readable;

/** Created by Konstantin Lugowoy on 25.07.2017. */

public abstract class ReadingData implements Readable {

    @Override
    public abstract byte readByte();

    @Override
    public abstract short readShort();

    @Override
    public abstract int readInt();

    @Override
    public abstract long readLong();

    @Override
    public abstract char readChar();

    @Override
    public abstract float readFloat();

    @Override
    public abstract double readDouble();

    @Override
    public abstract String readString();

}
