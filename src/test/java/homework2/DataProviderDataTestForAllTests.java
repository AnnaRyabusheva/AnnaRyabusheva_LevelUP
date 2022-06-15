package homework2;

import org.testng.annotations.DataProvider;

public class DataProviderDataTestForAllTests {
    @DataProvider
    static Object[][] sumData() {
        return new Object[][] {
            {2, 4, 6},
            {6, 5, 11},
            {8, 1, 9},
            {9, 14, 23}
        };
    }

    @DataProvider
    static Object[][] multiplyData() {
        return new Object[][] {
            {2, 4, 8},
            {6, 5, 30},
            {8, 1, 8},
            {15, 2, 30}
        };
    }

    @DataProvider
    static Object[][] subtractData() {
        return new Object[][] {
            {12, 4, 8},
            {6, 5, 1},
            {8, 1, 7},
            {15, 2, 13}
        };
    }

    @DataProvider
    static Object[][] divData() {
        return new Object[][] {
            {12, 4, 3},
            {30, 5, 6},
            {100, 2, 50},
            {18, 2, 9}
        };
    }
}
