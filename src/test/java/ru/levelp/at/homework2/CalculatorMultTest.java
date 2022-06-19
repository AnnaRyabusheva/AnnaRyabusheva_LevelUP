package ru.levelp.at.homework2;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CalculatorMultTest extends CalculatorBaseTest {

    @Test(dataProviderClass = DataProviderDataTestForAllTests.class, dataProvider = "multiplyData")
    public void calculatorMultiplyTest(long a, long b, long expected) {

        long actual = calculator.mult(a, b);
        assertEquals(actual, expected);
    }

    @Test(dataProviderClass = DataProviderDataTestForAllTests.class, dataProvider = "multiplyDoubleData")
    public void calculatorMultiplyTest(double a, double b, double expected) {

        double actual = calculator.mult(a, b);
        assertEquals(actual, expected);
    }
}
