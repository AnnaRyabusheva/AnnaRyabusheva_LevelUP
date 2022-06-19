package ru.levelp.at.homework2;

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
    static Object[][] sumDataDouble() {
        return new Object[][] {
            {8.5, 2.3, 10.8},
            {1.9, 25.8, 27.7},
            {9.78, 58.563, 68.343}
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
    static Object[][] multiplyDoubleData() {
        return new Object[][] {
            {2.5, 4.2, 10.0},
            {6.2, 5.8, 35.0},
            {9.7, 1, 9.0},
            {56.2548, 34.2587, 1927.0}
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
    static Object[][] subtractDoubleData() {
        return new Object[][] {
            {12.8, 4.7, 8.100000000000001},
            {61.52, 32.89, 28.630000000000003},
            {69.876, 12.5267, 57.34930000000001}
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

    @DataProvider
    static Object[][] divDataDouble() {
        return new Object[][] {
            {12.8, 4.2, 3.0476190476190474},
            {33.6, 5.6, 6.000000000000001},
            {100, 2.5, 40},
            {25.2, 2.5, 10.08}
        };
    }

    @DataProvider
    static Object[][] divDataPow() {
        return new Object[][] {
            {2, 2, 4},
            {3, 2, 9},
            {4, 2, 16}
        };
    }

    @DataProvider
    static Object[][] sqrlData() {
        return new Object[][] {
            {16, 4},
            {9, 3},
            {16, 4}
        };
    }

    @DataProvider
    static Object[][] tgData() {
        return new Object[][] {
            {30.0, 5.477225575051661},
            {45.0, 6.708203932499369}
        };
    }

    @DataProvider
    static Object[][] ctgData() {
        return new Object[][] {
            {60, 7.745966692414834},
            {45.0, 6.708203932499369}
        };
    }

    @DataProvider
    static Object[][] cosData() {
        return new Object[][] {
            {72, 8.48528137423857},
            {85, 9.219544457292887}
        };
    }

    @DataProvider
    static Object[][] sinData() {
        return new Object[][] {
            {30.0, 5.477225575051661},
            {61, 7.810249675906654}
        };
    }
}
