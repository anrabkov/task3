package test.rabkov.task3.validatorTest;

import com.rabkov.task3.exception.SphereException;
import com.rabkov.task3.validator.FileNameValidator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.rabkov.task3.util.Util;


import java.io.File;

public class FileNameValidatorTest {

    private FileNameValidator validator;
    private Util util;

    @BeforeClass
    public void SetUp(){
        validator = new FileNameValidator();
        util = new Util();
    }

    @Test
    public void FileNameNullTest() throws SphereException {
        Assert.assertFalse(validator.validateFile(null));
    }

    @Test
    public void FileNameIsBlank() throws SphereException {
        Assert.assertFalse(validator.validateFile(""));
    }

    @Test
    public void FileExistAndIsNotEmpty() throws SphereException {
        File file = new File(util.getFilePath("data/data.txt"));
        Assert.assertTrue(file.exists() && file.length() > 0);
    }

    @Test
    public void FileExistAndIsEmpty() throws SphereException {
        File file = new File(util.getFilePath("data/empty.txt"));
        Assert.assertFalse(file.exists() && file.length() > 0);
    }
}
