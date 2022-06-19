package ru.levelp.at.homework2;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CalculatorAnotherTest extends CalculatorBaseTest {

    @Test(dataProviderClass = DataProviderDataTestForAllTests.class, dataProvider = "divDataPow")
    public void calculatorPowTest(double a, double b, double expected) {

        double actual = calculator.pow(a, b);
        assertEquals(actual, expected);
    }

    @Test(dataProviderClass = DataProviderDataTestForAllTests.class, dataProvider = "sqrlData")
    public void calculatorSqrtTest(double a, double expected) {

        double actual = calculator.sqrt(a);
        assertEquals(actual, expected);
    }
}
