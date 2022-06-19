package ru.levelp.at.homework2;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CalculatorSumTest extends CalculatorBaseTest {

    @Test(dataProviderClass = DataProviderDataTestForAllTests.class, dataProvider = "sumData")
    public void calculatorSumTest(long a, long b, long expected) {

        long actual = calculator.sum(a, b);
        assertEquals(actual, expected);
    }

    @Test(dataProviderClass = DataProviderDataTestForAllTests.class, dataProvider = "sumDataDouble")
    public void calculatorSumDoubleTest(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        assertEquals(actual, expected);
    }
}

