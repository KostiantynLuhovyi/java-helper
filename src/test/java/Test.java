import com.lugowoy.helper.filling.ValuesToFilling;
import com.lugowoy.helper.filling.array.numbers.*;
import com.lugowoy.helper.filling.array.points.FillingArrayPoints2DReadIntegers;
import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomIntegers;
import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomPrimitiveDoubles;
import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomPrimitiveIntegers;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.matrices.AbstractMatrix;
import com.lugowoy.helper.models.matrices.Matrix;
import com.lugowoy.helper.models.matrices.MatrixDoubles;
import com.lugowoy.helper.models.matrices.MatrixInts;
import com.lugowoy.helper.models.points.Point2D;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.models.storages.arrays.ArrayDoubles;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.generating.GeneratorRandomNumber;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_LOWER_BOUND;
import static com.lugowoy.helper.filling.ValuesToFilling.INT_UPPER_BOUND;
import static com.lugowoy.helper.models.matrices.AbstractMatrix.DEFAULT_COLUMNS;
import static com.lugowoy.helper.models.matrices.AbstractMatrix.DEFAULT_ROWS;

/**
 * Created by Konstantin Lugowoy on 02.10.2018.
 */

public class Test {

    public static void main(String[] args) throws InterruptedException {

        /*Matrix<Integer> matrix = Matrix.create(new FillingMatrixRandomInteger().fill(5, 5, INT_UPPER_BOUND));

        System.out.println("Matrix : ");
        System.out.println(matrix);

        Array<Integer> array = matrix.getColumnToArray(9);

        System.out.println("Array : " + array);

        matrix.getColumnToArray(array, 3);

        System.out.println("Array : " + array);

        Integer[] integers = new Integer[matrix.getRows()];

        matrix.getColumnToArray(integers, 2);

        System.out.println("Integer array : " + Arrays.toString(integers));

        matrix.deleteRow(2);

        System.out.println(matrix);
        System.out.println();

        matrix.deleteColumn(3);

        System.out.println(matrix);

        System.out.println("Columns");
        System.out.println(matrix.getColumnToArray(4));
        System.out.println("------------");
        System.out.println(Arrays.toString(matrix.getColumnToArray(new Integer[matrix.getColumns()], 4)));
        System.out.println("------------");
        System.out.println(matrix.getColumnToArray(Array.create(matrix.getColumns()), 4));

        System.out.println("Rows");
        System.out.println(matrix.getRowToArray(4));
        System.out.println("------------");
        System.out.println(Arrays.toString(matrix.getRowToArray(new Integer[matrix.getRows()], 4)));
        System.out.println("------------");
        System.out.println(matrix.getRowToArray(Array.create(matrix.getRows()), 4));

        Integer[] integers = new Integer[]{-2, -2, -2, -2, -2};
        matrix.setRowFromArray(integers, 0);
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

/*        Matrix<Integer> matrix = new Matrix<>(new FillingMatrixRandomIntegers().fill(DEFAULT_ROWS, DEFAULT_COLUMNS, 0, 50));

        System.out.println(matrix);*/

/*        Matrix<Integer> matrixToTest = new Matrix<>(matrix);

        System.out.println(matrixToTest);*/

/*        Array<Integer> arrayFirst = new Array<>(new FillingArrayRandomIntegers().fill(5, -20, -1));
        Array<Integer> arraySecond = new Array<>(new FillingArrayRandomIntegers().fill(6, -20, -1));

        matrix.setRowFromArray(arrayFirst, 2);
        matrix.setRowFromArray(arraySecond, 7);

        System.out.println(matrix);

        Array<Integer> arrayFromRowOfMatrix = matrix.getRowToArray(2);
        Integer[] integersFromRowOfMatrix = new Integer[2];
        integersFromRowOfMatrix = matrix.getRowToArray(integersFromRowOfMatrix, 2);

        System.out.println(arrayFromRowOfMatrix);
        System.out.println(Arrays.toString(integersFromRowOfMatrix));
        System.out.println();

        integersFromRowOfMatrix[0] = 1000000000;
        System.out.println(Arrays.toString(integersFromRowOfMatrix));
        System.out.println();

        System.out.println(matrix);

        Integer[][] integersMatrix = new Integer[3][10];

        integersMatrix = matrix.toAnyMatrix(integersMatrix);

        System.out.println(Arrays.deepToString(integersMatrix));

        System.out.println();
        System.out.println("------------Column (get)---------------------");
        System.out.println();

        System.out.println(matrix.getColumnToArray(3));
        System.out.println(matrix.getColumnToArray(8));

        Integer[][] matrix1 = new Integer[3][7];
        matrix1 = matrix.toMatrix(matrix1);
        System.out.println(Arrays.deepToString(matrix1));*/

/*        MatrixInts matrix = new MatrixInts(5, 4);
        System.out.println(matrix);*/

/*        Array<Integer> array = new Array<>(new FillingArrayRandomIntegers().fill(10, 400, 500));
        System.out.println(array);

        Array<Integer> array1 = new Array<>();
        array1.setArray((Integer[]) array.toArray());
        System.out.println(array1);

        Integer[] integer = new Integer[] {2, 14, 5, 7, 20};
        Integer[] integer1 = Arrays.copyOf(integer, integer.length);
        System.out.println(Arrays.toString(integer));
        System.out.println(Arrays.toString(integer1));
        integer[1] = 4554545;
        integer1[1] = 30000;
        System.out.println(Arrays.toString(integer));
        System.out.println(Arrays.toString(integer1));
        System.out.println("--------------------");

        System.out.println("integ : " + (integer == integer1));

        System.out.println(array.toArray() == array1.toArray());
        System.out.println(" jjkjkj " + (array.get(4) == array1.get(4)));
        System.out.println(array.equals(array1));
        System.out.println(Arrays.equals(array.toArray(), array1.toArray()));
        array.set(3, 100000);
        array1.set(5, 99999999);
        array1.add(44444);
        array.remove(6);
        Array<Integer> array2 = new Array<>(new FillingArrayRandomIntegers().fill(20, INT_LOWER_BOUND, INT_UPPER_BOUND));
        System.out.println(array2);
        array.addAll(array2);
        System.out.println(array);
        System.out.println(array1);
        System.out.println(array.toArray() == array1.toArray());
        System.out.println(array.hashCode() == array1.hashCode());

        Human[] humans = new Human[4];
        humans[0] = new Human(new Adress("Avangardnaya"), 28);
        humans[1] = new Human(new Adress("Guryevskaya"), 70);
        humans[2] = new Human(new Adress("LuiPastera"), 35);
        humans[3] = new Human(new Adress("Zubareva"), 40);

        System.out.println(Arrays.toString(humans));
        Human[] humans1 = Arrays.copyOf(humans, humans.length);
        System.out.println(Arrays.toString(humans1));

        humans1[1] = new Human(new Adress("ddsffsdsfd"), 444);

        System.out.println(Arrays.toString(humans));
        System.out.println(Arrays.toString(humans1));

        System.out.println("++++++++++++++++++++++++++++");
        String[] strings = new String[] {"1", "2", "3", "4", "5"};
        String[] strings1 = Arrays.copyOf(strings, strings.length);

        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(strings1));

        strings1[1] = "67890";

        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(strings1));

        System.out.println("============================");

        Array<Integer> integerArray = new Array<>(integer);
        System.out.println(Arrays.toString(integerArray.toArray()));
        System.out.println(Arrays.toString(integer));
        System.out.println(integer == integerArray.toArray());
        System.out.println(integer[1] == integerArray.get(1));

        *//*integer[1] = 10010101;*//*
        integerArray.set(3, 4444444);

        System.out.println(Arrays.toString(integerArray.toArray()));
        System.out.println(Arrays.toString(integer));

        System.out.println("00000000000000000000000000000");
        Array<Human> humanArray = new Array<>(humans);
        System.out.println(Arrays.toString(humans));
        System.out.println(Arrays.toString(humanArray.toArray()));

        humans[1] = new Human(new Adress("dfdsfdsfsdf"), 90);

        System.out.println(Arrays.toString(humans));
        System.out.println(Arrays.toString(humanArray.toArray()));

        System.out.println("((((((((((((((((((((((((");
        System.out.println(integerArray);
        integerArray.add(1, 777777);
        System.out.println(integerArray);

        List<Integer> integerList = new LinkedList<>();
        integerList.add(555);
        integerList.add(555);
        integerList.add(555);
        integerList.add(555);
        integerList.add(555);
        integerList.add(555);

        integerArray.addAll(integerList);
        integerArray.addAll(1, integerList);

        System.out.println(integerArray + ", size: " + integerArray.size());*/

/*        integerList.clear();
        integerList.add(4554545);
        integerList.add(5);
        integerList.add(4444444);*/

        /*integerArray.remove(7);*/
/*        integerArray.removeAll(integerList);
        integerArray.removeAll(integerList);

        System.out.println("bla");
        System.out.println(integerArray);
        System.out.println("bla");

        System.out.println("^^^^^^^^^^^^^^^^^^");

        ArrayInts arrayInts = new ArrayInts(new FillingArrayRandomPrimitiveIntegers().fill(10*//*0_0000*//*, INT_LOWER_BOUND, INT_UPPER_BOUND));*/
/*

        int[] ints = new int[4];
*/

        /*ArrayInts arrayInts1 = ArrayInts(new FillingArrayRandomPrimitiveIntegers().fill(1000, );)*/
/*
        long start = System.currentTimeMillis();
        System.out.println(start);*/

/*        System.out.println(arrayInts);

        arrayInts.add(777);*/

/*        long finish = System.currentTimeMillis();
        System.out.println(finish);

        long res = finish - start;*/

/*        System.out.println(arrayInts);

        arrayInts.removeByIndex(1);

        System.out.println(arrayInts);

        arrayInts.add(7, 777);
        arrayInts.add(4, 777);

        System.out.println(arrayInts);

        arrayInts.removeAll(777);

        System.out.println(arrayInts);*/


        /*System.out.println("Time : " + res);*/

        /*
        ints = arrayInts.toArray(new int[0]);

        System.out.println(Arrays.toString(ints));
        */

/*        Array<Integer> array = new Array<>(new FillingArrayRandomIntegers().fill(500, -100, 100));
        Array<Integer> array1 = new Array<>(new FillingArrayRandomIntegers().fill(3, -100, 100));

        System.out.println(array);
        System.out.println(array1);

        System.out.println(array.containsAll(array1));*/

        MatrixInts matrixInts = new MatrixInts(new FillingMatrixRandomPrimitiveIntegers().fill(10, 10, -1000, 1000));
/*        System.out.println(matrixInts);

        MatrixDoubles matrixDoubles = new MatrixDoubles(new FillingMatrixRandomPrimitiveDoubles().fill(10, 10, -10, 10));
        System.out.println(matrixDoubles);*/

/*        File file = new File("C:/newfile.txt");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file, true)){
                if (file.exists()) {
                    file.createNewFile();
                }
            *//*fileOutputStream.write(matrixInts.toString().getBytes());*//*
            String toWrite = matrixInts.toString();
            for (int i = 0; i < toWrite.length(); i++) {
                fileOutputStream.write(toWrite.charAt(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

/*        Array<Point2D<Integer>> pointsArray = new Array<>(new FillingArrayPoints2DReadIntegers(new ReadingConsole()).fill(10, -10, 10));

        System.out.println(pointsArray);*/

        System.out.println("ArrayInts");
        ArrayInts arrayInts = new ArrayInts(new FillingArrayRandomPrimitiveIntegers().fill(10, 1000, 10000));
        System.out.println(arrayInts);
        arrayInts.add(5, 777777);
        System.out.println(arrayInts);

        System.out.println("ArrayDoubles");
        ArrayDoubles arrayDoubles = new ArrayDoubles(new FillingArrayRandomPrimitiveDoubles().fill(10, 1000, 10000));
        System.out.println(arrayDoubles);
        arrayDoubles.add(5, 77777777);
        System.out.println(arrayDoubles);

        System.out.println("Array");
        Array<Integer> array = new Array<>(new FillingArrayRandomIntegers().fill(10, 1000, 10000));
        System.out.println(array);
        array.add(5, 777777);
        System.out.println(array);

        arrayInts.add(0, 8888888);

        System.out.println(arrayInts);

        arrayDoubles.add(10, 10010101);
        System.out.println(arrayDoubles);


        ArrayList<Integer> arrayList = new ArrayList<>(2222);
        arrayList.add(34);
        /*int i = 0;
        while (i < arrayList.size()) {
            arrayList.add(GeneratorRandomNumber.generateInt(-10, 10));
            i++;
        }*/
        System.out.println(arrayList + " : " + arrayList.size());

        Array<Integer> integerArray = new Array<>(11);
        integerArray.add(55);
        System.out.println(integerArray);

        Array<Integer> integerArray1 = new Array<>();
        integerArray1.add(45);
        integerArray1.add(7676);
        System.out.println(integerArray1);

    }

    static void insertElement(int element, ArrayInts array) {
        if (CheckerArray.checkLengthInArray(array)) {
            for (int i = 0; i < array.size(); i++) {
                if (element < array.get(i)) {
                    System.out.println(i + " - " + element + " : " + array.get(i));
                    array.add(i, element);
                    break;
                }
            }
            System.out.println(array);
            /*if (element >= array.get(0) && element <= array.get(array.size() - 1)) {
                for (int i = 0; i < array.size(); i++) {
                    if (element >= array.get(i)) {
                        array.add(i, element);
                    }
                }
            } else {
                System.out.println("The element does not correspond to the sequence.");
            }*/
        }
    }

/*    private static class Human {

        private Adress adress;
        private int age;

        public Human(Adress adress, int age) {
            this.adress = adress;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Human)) return false;
            Human human = (Human) o;
            return getAge() == human.getAge() &&
                    Objects.equals(getAdress(), human.getAdress());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getAdress(), getAge());
        }

        @Override
        public String toString() {
            return "Human{" +
                    "adress=" + adress +
                    ", age=" + age +
                    '}';
        }

        public Adress getAdress() {
            return adress;
        }

        public int getAge() {
            return age;
        }

    }

    private static class Adress {

        private String adress;

        public Adress(String adress) {
            this.adress = adress;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Adress)) return false;
            Adress adress1 = (Adress) o;
            return Objects.equals(getAdress(), adress1.getAdress());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getAdress());
        }

        @Override
        public String toString() {
            return "Adress{" +
                    "adress='" + adress + '\'' +
                    '}';
        }

        public String getAdress() {
            return adress;
        }

    }*/

}
