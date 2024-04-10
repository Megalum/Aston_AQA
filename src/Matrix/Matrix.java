package Matrix;

import java.util.Objects;

public class Matrix {
    private int sum;
    public Matrix(){
        sum = 0;
    }

    public int getSum() {
        return sum;
    }

    public void addition(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4){
            throw new MyArraySizeException();
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (isNumber(Objects.requireNonNull(array[i][j]))) {
                    sum += Integer.parseInt(array[i][j]);
                } else {
                    throw new MyArrayDataException(i,j);
                }
            }
        }
    }

    private static boolean isNumber(String str){
        return str.matches("-?\\d+?");
    }
}
