package ru.levelp.at.homework2;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CalculatorFunctionTest extends CalculatorBaseTest {

    @Test(dataProviderClass = DataProviderDataTestForAllTests.class, dataProvider = "tgData")
    public void calculatorTgTest(double a, double expected) {

        double actual = calculator.sqrt(a);
        assertEquals(actual, expected);
    }

    @Test(dataProviderClass = DataProviderDataTestForAllTests.class, dataProvider = "ctgData")
    public void calculatorCtgTest(double a, double expected) {

        double actual = calculator.sqrt(a);
        assertEquals(actual, expected);
    }

    @Test(dataProviderClass = DataProviderDataTestForAllTests.class, dataProvider = "cosData")
    public void calculatorCosTest(double a, double expected) {

        double actual = calculator.sqrt(a);
        assertEquals(actual, expected);
    }

    @Test(dataProviderClass = DataProviderDataTestForAllTests.class, dataProvider = "sinData")
    public void calculatorSinTest(double a, double expected) {

        double actual = calculator.sqrt(a);
        assertEquals(actual, expected);
    }
}
