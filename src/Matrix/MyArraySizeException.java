package Matrix;

public class MyArraySizeException extends Throwable  {
    public MyArraySizeException()  {
        super("Размер двумерного массива должен быть 4х4!");
    }
}
