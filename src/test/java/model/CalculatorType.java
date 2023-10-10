package model;

public class CalculatorType {
    private String googleSearchTerm;
    private String googleSearchResult;
    private String calculatorType;

    public CalculatorType(String googleSearchTerm, String googleSearchResult, String calculatorType) {
        this.googleSearchTerm = googleSearchTerm;
        this.googleSearchResult = googleSearchResult;
        this.calculatorType = calculatorType;
    }

    public String getCalculatorType() {
        return calculatorType;
    }

    public String getGoogleSearchTerm() {
        return googleSearchTerm;
    }

    public String getGoogleSearchResult() {
        return googleSearchResult;
    }
}
