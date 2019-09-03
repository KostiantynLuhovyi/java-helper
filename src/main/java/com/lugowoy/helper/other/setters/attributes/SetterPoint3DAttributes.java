package com.lugowoy.helper.other.setters.attributes;

import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.points.Point3D;

import java.io.IOException;
import java.io.OutputStream;

import static com.lugowoy.helper.other.setters.attributes.SetterAttributes.*;

/**
 * Created by LugowoyKonstantin on 03.09.2019.
 *
 * @author LugowoyKonstantin
 * @version 1.0
 * @since 1.7.4
 */
//todo add doc's (class, methods)
public class SetterPoint3DAttributes<T extends Number> extends SetterPointAttributes<Point3D<T>> /*implements SetterAttributes<Point3D<T>> */ {

    @Override
    public void setAttributes(Point3D<T> point3D) {
        if (isNonNullObject(point3D)) {
            point3D.setX((T) new Double(0.0));
            point3D.setY((T) new Double(0.0));
            point3D.setZ((T) new Double(0.0));
        }
    }

    @Override
    public void setAttributes(Point3D<T> point3D, Reading reader) {
        if (isNonNullObject(point3D)) {
            if (isNonNullReader(reader)) {
                point3D.setX((T) new Double(reader.readDouble()));
                point3D.setY((T) new Double(reader.readDouble()));
                point3D.setZ((T) new Double(reader.readDouble()));
            }
        }
    }

    public void setAttributes(Point3D<T> point3D, Reading reader, OutputStream outputStreamToMsg,
                              String msgCoorX, String msgCoorY, String msgCoorZ) {
        if (isNonNullObject(point3D)) {
            if (isNonNullReader(reader)) {
                if (isNonNullOutputStream(outputStreamToMsg)) {
                    try {
                        outputStreamToMsg.write(msgCoorX.getBytes());
                        point3D.setX((T) new Double(reader.readDouble()));
                        outputStreamToMsg.write(msgCoorY.getBytes());
                        point3D.setY((T) new Double(reader.readDouble()));
                        outputStreamToMsg.write(msgCoorZ.getBytes());
                        point3D.setZ((T) new Double(reader.readDouble()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void setAttributes(Point3D<T> point3D, T coorX, T coorY, T coorZ) {
        if (isNonNullObject(point3D)) {
            point3D.setX(coorX);
            point3D.setY(coorY);
            point3D.setZ(coorZ);
        }
    }

}
