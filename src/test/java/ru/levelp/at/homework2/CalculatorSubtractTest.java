package ru.levelp.at.homework2;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CalculatorSubtractTest extends CalculatorBaseTest {

    @Test(dataProviderClass = DataProviderDataTestForAllTests.class, dataProvider = "subtractData")
    public void calculatorSubTest(long a, long b, long expected) {

        long actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }

    @Test(dataProviderClass = DataProviderDataTestForAllTests.class, dataProvider = "subtractDoubleData")
    public void calculatorSubTest(double a, double b, double expected) {

        double actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }
}
