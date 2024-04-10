package Matrix;

public class MyArrayDataException extends Throwable {
    public MyArrayDataException (int i, int j) {
        super("В ячейке (" + i + ", " + j + ") лежат некорректные данные!");
    }

}
