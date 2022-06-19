package ru.levelp.at.homework2;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;



public class CalculatorFuncTest extends CalculatorBaseTest {
    @Test(dataProviderClass = DataProviderDataTestForAllTests.class, dataProvider = "divDataPow")
    public void calculatorFunTest(double a, double b, double expected) {
        double actual = calculator.pow(a, b);
        assertEquals(actual, expected);
    }
}
