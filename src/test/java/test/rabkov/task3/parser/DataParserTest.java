package test.rabkov.task3.parser;

import com.rabkov.task3.parser.DataParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataParserTest {
    private DataParser dataParser;

    @Test
    public void parseTest() {
        dataParser = new DataParser();
        List<String> originalData = Arrays.asList(" 122   1.25  2.25 0.25  3", " 4  5 8 9",
                " 4445 df5 ds5  ds55dsr e44r", " 4.25 455           0.12            0.15");

        List<List<Double>> actualList = dataParser.parseString(originalData);
        List<List<Double>> expectedList = new ArrayList<>();
        List<Double> firstList = Arrays.asList(4.0, 5.0, 8.0, 9.0);
        List<Double> secondList = Arrays.asList(4.25, 455.0, 0.12, 0.15);
        expectedList.add(firstList);
        expectedList.add(secondList);

        Assert.assertEquals(actualList, expectedList);
    }
}
