package Matrix;

public class Task {
    public static void run() throws MyArraySizeException, MyArrayDataException {
        String[][] array = {
                {"15","7","3","17"},
                {"7","-12","1","12"},
                {"8","1","-9","3"},
                {"12","5","14","-6"}
        };
        String[][] array1 = {
                {"15","7","3","17"},
                {"7","-12","1","12"},
                {"8","1","-9","3"},
        };
        String[][] array2 = {
                {"15","7","3","17"},
                {"8","-12","Q","12"},
                {"8","O","-9","3"},
                {"12","5","0","-6"}
        };
        Matrix matrix = new Matrix();
        matrix.addition(array);
        System.out.println("Сумма матрицы: " + matrix.getSum());


    }
}
