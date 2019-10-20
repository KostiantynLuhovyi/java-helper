package com.lugowoy.helper.utils.setters.attributes;

import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.points.Point2D;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Konstantin Lugowoy on 01.09.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.7.4
 */
//todo write doc's
public class SetterPoint2DAttributes<T extends Number> extends SetterPointAttributes<Point2D<T>> {

    @Override
    public void setAttributes(Point2D<T> point2D) {
        if (point2D != null) {
            point2D.setX((T) Double.valueOf(0.0));
            point2D.setY((T) Double.valueOf(0.0));
        } else {
            throw new NullPointerException("Point2D is null.");
        }
    }

    @Override
    public void setAttributes(Point2D<T> point2D, Reading reader) {
        if (point2D != null) {
            if (reader != null) {
                point2D.setX((T) Double.valueOf(reader.readDouble()));
                point2D.setY((T) Double.valueOf(reader.readDouble()));
            } else {
                throw new NullPointerException("Reader is null.");
            }
        } else {
            throw new NullPointerException("Point2D is null.");
        }
    }

    public void setAttributes(Point2D<T> point2D, Reading reader, OutputStream outputStreamToMsg,
                              String msgCoordinateX, String msgCoordinateY) {
        if (point2D != null) {
            if (reader != null) {
                if (outputStreamToMsg != null) {
                    try {
                        outputStreamToMsg.write(msgCoordinateX.getBytes());
                        point2D.setX((T) Double.valueOf(reader.readDouble()));
                        outputStreamToMsg.write(msgCoordinateY.getBytes());
                        point2D.setY((T) (T) Double.valueOf(reader.readDouble()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    throw new NullPointerException("Output stream is null.");
                }
            } else {
                throw new NullPointerException("Reader is null");
            }
        } else {
            throw new NullPointerException("Point2D is null.");
        }
    }

    public void setAttributes(Point2D<T> point2D, T coordinateX, T coordinateY) {
        if (point2D != null) {
            point2D.setX(coordinateX);
            point2D.setY(coordinateY);
        } else {
            throw new NullPointerException("Point2D is null.");
        }
    }

}
