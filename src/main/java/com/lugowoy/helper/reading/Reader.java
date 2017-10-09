package com.lugowoy.helper.reading;

import com.lugowoy.helper.reading.readable.Readable;

/** Created by Konstantin Lugowoy on 26.07.2017. */

public  class Reader implements Readable {

    private ReadingData readingData;

    public Reader(ReadingData readingData) {
        this.readingData = readingData;
    }

    @Override
    public byte readByte() {
        return this.readingData.readByte();
    }

    @Override
    public short readShort() {
        return this.readingData.readShort();
    }

    @Override
    public int readInt() {
        return this.readingData.readInt();
    }

    @Override
    public long readLong() {
        return this.readingData.readLong();
    }

    @Override
    public float readFloat() {
        return this.readingData.readFloat();
    }

    @Override
    public double readDouble() {
        return this.readingData.readDouble();
    }

    @Override
    public String readString() {
        return this.readingData.readString();
    }

}
