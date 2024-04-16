import org.example.Factorial;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.example.Factorial.*;
import static org.testng.Assert.assertThrows;

public class FactorialTest {

    @Test
    void factorialsExpression(){
        assertEquals(run(4), 24);
    }

    @Test
    void expectedIllegalStateExceptionOnInvalidFactorial(){
        assertThrows(IllegalStateException.class, () -> Factorial.run(-5));
    }
}
