package com.lugowoy.helper.other.setters.attributes;

import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.points.Point2D;

import java.io.IOException;
import java.io.OutputStream;

import static com.lugowoy.helper.other.setters.attributes.SetterAttributes.*;

/**
 * Created by LugowoyKonstantin on 01.09.2019.
 *
 * @author LugowoyKonstantin
 * @version 1.0
 * @since 1.7.4
 */
//todo add doc's (class, methods)
public class SetterPoint2DAttributes<T extends Number> extends SetterPointAttributes<Point2D<T>> /*implements SetterAttributes<Point2D<T>>*/ {

    @Override
    public void setAttributes(Point2D<T> point2D) {
        if (isNonNullObject(point2D)) {
            point2D.setX((T) new Double(0.0));
            point2D.setY((T) new Double(0.0));
        }
    }

    @Override
    public void setAttributes(Point2D<T> point2D, Reading reader) {
        if (isNonNullObject(point2D)) {
            if (isNonNullReader(reader)) {
                point2D.setX((T) new Double(reader.readDouble()));
                point2D.setY((T) new Double(reader.readDouble()));
            }
        }
    }

    public void setAttributes(Point2D<T> point2D, Reading reader, OutputStream outputStreamToMsg,
                              String msgCoorX, String msgCoorY) {
        if (isNonNullObject(point2D)) {
            if (isNonNullReader(reader)) {
                if (isNonNullOutputStream(outputStreamToMsg)) {
                    try {
                        outputStreamToMsg.write(msgCoorX.getBytes());
                        point2D.setX((T) new Double(reader.readDouble()));
                        outputStreamToMsg.write(msgCoorY.getBytes());
                        point2D.setY((T) new Double(reader.readDouble()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void setAttributes(Point2D<T> point2D, T coorX, T coorY) {
        if (isNonNullObject(point2D)) {
            point2D.setX(coorX);
            point2D.setY(coorY);
        }
    }

}
