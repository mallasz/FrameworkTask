package service;

import model.CalculatorType;

public class CalculatorTypeCreator {
    public static final String TESTDATA_CALCULATOR_SEARCHTERM = "testdata.calculator.searchterm";
    public static final String TESTDATA_CALCULATOR_RESULT = "testdata.calculator.result";
    public static final String TESTDATA_CALCULATOR_TYPE = "testdata.calculator.type";

    public static CalculatorType withDataFromProperty(){
        return new CalculatorType(TestDataReader.getTestData(TESTDATA_CALCULATOR_SEARCHTERM),
                TestDataReader.getTestData(TESTDATA_CALCULATOR_RESULT),
                TestDataReader.getTestData(TESTDATA_CALCULATOR_TYPE));
    }
}
