package homework2;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CalculatorMultiplyTest extends CalculatorBaseTest {

    @Test(dataProviderClass = DataProviderDataTestForAllTests.class, dataProvider = "multiplyData")
    public void calculatorMultiplyTest(long a, long b, long expected) {

        long actual = calculator.mult(a, b);
        assertEquals(actual, expected);
    }
}