package Matrix;

public class Matrix {

    public void addition(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        if (array.length != 4){
            throw new MyArraySizeException();
        }
        for (int i = 0; i < 4; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < 4; j++) {
                if (array[i][j] == null || !isNumber(array[i][j])) {
                    throw new MyArrayDataException(i,j);
                }
                sum += Integer.parseInt(array[i][j]);
            }
        }
        System.out.println("Сумма матрицы: " + sum);
    }

    private static boolean isNumber(String str){
        return str.matches("-?\\d+?");
    }
}
