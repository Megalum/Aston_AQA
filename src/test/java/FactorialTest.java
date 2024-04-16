import org.junit.jupiter.api.Test;
import ru.Factorial;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class FactorialTest {
    @Test
    void factorialsExpression(){
        assertThat(Factorial.run(4)).isEqualTo(24);
    }

    @Test
    void expectedIllegalStateExceptionOnInvalidFactorial(){
        assertThatThrownBy(() -> Factorial.run(-5)).isInstanceOf(IllegalStateException.class)
                .describedAs("Ошибка. Факториал не может быть отрицательным!");
    }

    @Test
    void getOperandCompletesCorrectlyWithNumbers(){
        String testedValue = "7";
        ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
        InputStream inputStream = System.in;
        System.setIn(in);

        Factorial.getNumber();

        System.out.println(testedValue);
        System.setIn(inputStream);
    }

    @Test
    void getOperandCompletesCorrectlyWithNotNumbers(){
        String testedValue = "k";
        ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream inputStream = System.in;
        System.setIn(in);
        System.setOut(new PrintStream(out));

        assertThatThrownBy(Factorial::getNumber).isInstanceOf(IllegalStateException.class)
                .describedAs("Ошибка вводимых данных");

        System.setIn(inputStream);
        System.setOut(null);
    }
}
