package com.lugowoy.helper.filling;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;

/**
 * Created by Konstantin Lugowoy on 05.10.2018.
 */
//todo add doc's
public abstract class FillingReadValues {

    private Reader reader;

    public FillingReadValues(Reader reader) {
        this.reader = reader;
    }

    public FillingReadValues(Reading reading) {
        this.reader = Reader.getReader(reading);
    }

    public Reader getReader() {
        return reader;
    }

}
