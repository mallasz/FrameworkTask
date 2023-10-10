package service;

import com.opencsv.bean.CsvToBeanBuilder;
import model.CalculatorSettings;
import utils.ResourceLoader;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorSettingReader {
    public static final String TESTDATA_CALCULATORSETTINGS_CSV = "testdata.calculatorsettings.filename";
    public static final String TESTDATA_CALCULATORSETTINGS_ROW = "testdata.calculatorsettings.row";

    public static CalculatorSettings getCalculatorSettingsCSVFromProperty() {
        String filePath = ResourceLoader.getPathOfResource(TestDataReader.getTestData(TESTDATA_CALCULATORSETTINGS_CSV));
        try {
            return new CsvToBeanBuilder<CalculatorSettings>(new FileReader(filePath))
                    .withType(CalculatorSettings.class).withSeparator(';').build().parse().get(Integer.parseInt(TestDataReader.getTestData(TESTDATA_CALCULATORSETTINGS_ROW)));
        } catch (FileNotFoundException e) {
            assertThat("The resource CSV cannot be found under the given path:" + filePath, false);
            return null;
        }
    }
}
