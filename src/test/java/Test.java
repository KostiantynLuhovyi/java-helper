/**
 * Created by Konstantin Lugowoy on 02.10.2018.
 */

public class Test {

    public static void main(String[] args) throws InterruptedException {

        /*Matrix<Integer> matrix = Matrix.create(new FillingMatrixRandomInteger().fill(5, 5, INT_UPPER_BOUND));

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

        /*Array<Integer> array = new Array<>(new FillingArrayRandomIntegers().fill(10, 10, 20));

        System.out.println(array);

        Integer[] integer = array.toArray(new Integer[20]);
        System.out.println(Arrays.toString(integer));

        Integer resGetMethod = array.get(0);
        System.out.println(resGetMethod);

        System.out.println(array);*/

/*        Matrix<Integer> matrix = new Matrix<>(new Integer[-1][100]);

        System.out.println(matrix);*/


        /*for (int i = 0; i < 70; i++) {
            System.out.print(GeneratorRandomNumber.generateFloat() + " ");
        }*/

        /*
        String stop;
        while (true) {
            stop = Reader.getReader(new ReadingConsole()).readString();
            if (stop.equals("stop")) {
                break;
            } else {
                for (int i = 0; i < 2000; i++) {
                    System.out.print(GeneratorRandomNumber.generateDouble() + " ");
                }
            }
        }*/

        /*Matrix<Integer> matrix = new Matrix<>(new FillingMatrixRandomInteger().fill(10, 10, 20));

        System.out.println(matrix);

        System.out.println(matrix.getElement(3, 7));*/

/*        Matrix<Integer> matrix = new Matrix<>();

        setMatrixAttributes(matrix, new ReadingConsole(), System.out, MSG_ENTER_CONSOLE_ROW, MSG_ENTER_CONSOLE_COLUMN);

        matrix.setMatrix(new FillingMatrixRandomInteger().fill(matrix.getRows(), matrix.getColumns()));*/

/*        Point2D<Double> point2D = new Point2D<>(7.0, 7.0);
        System.out.println(point2D);
        SetterAttributes<Point2D<Double>> setterAttributes = new SetterPoint2DAttributes<>();
        setterAttributes.setAttributes(point2D);
        System.out.println(point2D);*/

        /*Array<Integer> array = new Array<>(new FillingArrayReadIntegers(new ReadingConsole()).fill(5));

        System.out.println(array);*/
/*        ReadingConsole readingConsole = new ReadingConsole();
        System.out.println(readingConsole.readByte());*/

/*        for (int i = 0; i < 10; i++) {
            System.out.println(GeneratorRandomNumber.generateFloat(-2, 3));
        }*/

/*
        System.out.println(new BigDecimal(-1895585.3532535235235E28).toPlainString());
        System.out.println(new BigDecimal(406770000244E+12));
        System.out.println(new BigDecimal(35554464646464646464648787441321351684868413131.79786111111116));
        System.out.println(new BigDecimal(3.375692414858597E307));
*/

/*        for (int i = 0; i < 10; i++) {
            System.out.print(GeneratorRandomNumber.generateInt(Integer.MAX_VALUE - 1, Integer.MAX_VALUE) + " ");
        }*/

        /*for (int i = 0; i < 50; i++) {
            System.out.println(GeneratorRandomNumber.generateInt(-10, -8));
        }*/

        /*ReadingConsole readingConsole = new ReadingConsole();
        int i = 0;
        while (i != -1) {
            i = readingConsole.readInt();
            if (i >= 0 && i <= Integer.MAX_VALUE) {
                System.out.println(i);
            }
        }*/


    }

}
