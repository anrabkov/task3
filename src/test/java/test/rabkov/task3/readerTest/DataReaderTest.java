package test.rabkov.task3.readerTest;

import com.rabkov.task3.exception.SphereException;
import com.rabkov.task3.reader.DataReader;
import org.junit.Test;
import org.testng.Assert;
import test.rabkov.task3.util.Util;

import java.util.ArrayList;
import java.util.List;


public class DataReaderTest {


    private final DataReader reader = new DataReader();
    private static final Util util = new Util();


    @Test
    public void readFromFileCorrectFile() throws SphereException {
        String correctFilePath = util.getFilePath("data/data.txt");
        List<String> expected = new ArrayList<>();
        expected.add(" 122   1.25  2.25 0.25  3");
        expected.add(" 4  5 8 9");
        expected.add(" 4445 df5 ds5  ds55dsr e44r");
        expected.add(" 4.25 455           0.12            0.15");

        List<String> actual = reader.readFromFile(correctFilePath);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void FileNullTest() throws SphereException {

        Assert.assertThrows(SphereException.class, () -> reader.readFromFile(null));
    }

    @Test
    public void FileNotExist(){

        Assert.assertThrows(SphereException.class, () -> reader.readFromFile("data/data1.txt"));
    }

    @Test
    public void FileFileEmptyTest(){
        String emptyFile = util.getFilePath("data/empty.txt");

        Assert.assertThrows(SphereException.class, () -> reader.readFromFile(emptyFile));
    }


}
