package com.lugowoy.helper.utils.setters.attributes;

import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.points.Point3D;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Konstantin Lugowoy on 03.09.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.7.4
 */
//todo write doc's
public class SetterPoint3DAttributes<T extends Number> extends SetterPointAttributes<Point3D<T>> {

    @Override
    public void setAttributes(Point3D<T> point3D) {
        if (point3D != null) {
            point3D.setX((T) Double.valueOf(0.0));
            point3D.setY((T) Double.valueOf(0.0));
            point3D.setZ((T) Double.valueOf(0.0));
        } else {
            throw new NullPointerException("Point3D is null.");
        }
    }

    @Override
    public void setAttributes(Point3D<T> point3D, Reading reader) {
        if (point3D != null) {
            if (reader != null) {
                point3D.setX((T) Double.valueOf(reader.readDouble()));
                point3D.setY((T) Double.valueOf(reader.readDouble()));
                point3D.setZ((T) Double.valueOf(reader.readDouble()));
            } else {
                throw new NullPointerException("Reader is null.");
            }
        } else {
            throw new NullPointerException("Point3D is null.");
        }
    }

    public void setAttributes(Point3D<T> point3D, Reading reader, OutputStream outputStreamToMsg,
                              String msgCoordinateX, String msgCoordinateY, String msgCoordinateZ) {
        if (point3D != null) {
            if (reader != null) {
                if (outputStreamToMsg != null) {
                    try (outputStreamToMsg) {
                        outputStreamToMsg.write(msgCoordinateX.getBytes());
                        point3D.setX((T) Double.valueOf(reader.readDouble()));
                        outputStreamToMsg.write(msgCoordinateY.getBytes());
                        point3D.setY((T) Double.valueOf(reader.readDouble()));
                        outputStreamToMsg.write(msgCoordinateZ.getBytes());
                        point3D.setZ((T) Double.valueOf(reader.readDouble()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    throw new NullPointerException("Output stream is null.");
                }
            } else {
                throw new NullPointerException("Reader is null.");
            }
        } else {
            throw new NullPointerException("Point3D is null.");
        }
    }

    public void setAttributes(Point3D<T> point3D, T coordinateX, T coordinateY, T coordinateZ) {
        if (point3D != null) {
            point3D.setX(coordinateX);
            point3D.setY(coordinateY);
            point3D.setZ(coordinateZ);
        } else {
            throw new NullPointerException("Point3D is null.");
        }
    }

}
