package homework2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

import org.testng.annotations.Test;

public class CalculatorDivTest extends CalculatorBaseTest {

    @Test(dataProviderClass = DataProviderDataTestForAllTests.class, dataProvider = "divData")
    public void calculatorDivTest(long a, long b, long expected) {

        long actual = calculator.div(a, b);
        assertEquals(actual, expected);
    }

    @Test
    void exceptionTesting() {
        assertThrows(NumberFormatException.class, () ->
            calculator.div(1, 0));
    }
}
