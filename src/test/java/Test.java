import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegerNumbers;
import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomIntegerNumbers;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.models.Matrix;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.models.points.Point2D;

import java.util.Arrays;

import static com.lugowoy.helper.filling.DefaultValuesForFilling.POSITIVE_INTEGER_BOUND;

/** Created by Konstantin Lugowoy on 02.10.2018. */

public class Test {

    public static void main(String[] args) {

        /*Matrix<Integer> matrix = Matrix.create(new FillingMatrixRandomIntegerNumbers().fill(5, 5, POSITIVE_INTEGER_BOUND));

        System.out.println("Matrix : ");
        System.out.println(matrix);

        Array<Integer> array = matrix.getColumn(9);

        System.out.println("Array : " + array);

        matrix.getColumn(array, 3);

        System.out.println("Array : " + array);

        Integer[] integers = new Integer[matrix.getRows()];

        matrix.getColumn(integers, 2);

        System.out.println("Integer array : " + Arrays.toString(integers));

        matrix.deleteRow(2);

        System.out.println(matrix);
        System.out.println();

        matrix.deleteColumn(3);

        System.out.println(matrix);

        System.out.println("Columns");
        System.out.println(matrix.getColumn(4));
        System.out.println("------------");
        System.out.println(Arrays.toString(matrix.getColumn(new Integer[matrix.getColumns()], 4)));
        System.out.println("------------");
        System.out.println(matrix.getColumn(Array.create(matrix.getColumns()), 4));

        System.out.println("Rows");
        System.out.println(matrix.getRow(4));
        System.out.println("------------");
        System.out.println(Arrays.toString(matrix.getRow(new Integer[matrix.getRows()], 4)));
        System.out.println("------------");
        System.out.println(matrix.getRow(Array.create(matrix.getRows()), 4));

        Integer[] integers = new Integer[]{-2, -2, -2, -2, -2};
        matrix.setRow(integers, 0);
        System.out.println(matrix);*/

/*        Point<Integer> point2D = new Point2D<>(3, 5 , 2);
        System.out.println(point2D);*/

        Array<Integer> array = new Array<>(new FillingArrayRandomIntegerNumbers().fill(Integer.MAX_VALUE, 20));

        System.out.println(array);

        Integer[] integer = array.toArray(new Integer[20]);
        System.out.println(Arrays.toString(integer));

        Integer resGetMethod = array.get(0);
        System.out.println(resGetMethod);

        System.out.println(array);

        Matrix<Integer> matrix = new Matrix<>(new Integer[-1][100]);

        System.out.println(matrix);


    }

}
