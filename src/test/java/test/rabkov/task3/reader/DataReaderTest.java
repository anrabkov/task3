package test.rabkov.task3.reader;

import com.rabkov.task3.exception.SphereException;
import com.rabkov.task3.reader.DataReader;
import org.junit.Test;
import org.testng.Assert;

import org.testng.annotations.BeforeClass;
import test.rabkov.task3.util.Util;

import java.util.ArrayList;
import java.util.List;


public class DataReaderTest {

    private DataReader reader;
    private Util util;

    @BeforeClass
    public void SetUp() {
        reader = new DataReader();
        util = new Util();
    }


    @Test
    public void readFromFileCorrectFile() throws SphereException {
        reader = new DataReader();
        List<String> expected = new ArrayList<>();
        expected.add(" 122   1.25  2.25 0.25  3");
        expected.add(" 4  5 8 9");
        expected.add(" 4445 df5 ds5  ds55dsr e44r");
        expected.add(" 4.25 455           0.12            0.15");

        List<String> actual = reader.readFromFile("data/data.txt");

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void FileNullTest() throws SphereException {
        reader = new DataReader();
        Assert.assertThrows(SphereException.class, () -> reader.readFromFile(null));
    }


    @Test
    public void FileEmptyTest() {
        String emptyFile = util.getFilePath("data/empty.txt");

        Assert.assertThrows(SphereException.class, () -> reader.readFromFile(emptyFile));
    }


}
