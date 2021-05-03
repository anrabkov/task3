package test.rabkov.task3.validator;

import com.rabkov.task3.validator.RegexValidator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegexValidatorTest {

    private RegexValidator validator;

    @BeforeClass
    public void SetUp() {
        validator = new RegexValidator();
    }

    @Test
    public void RegexIsValid() {
        Assert.assertTrue(validator.validateRegex("25  52.2 5.2    8          "));
    }

    @Test
    public void NumberOfNumbersMoreThanFour() {
        Assert.assertFalse(validator.validateRegex("5  8  8 5   8  5"));
    }

    @Test
    public void NumberOfNumbersLessThanFour() {
        Assert.assertFalse(validator.validateRegex("5  8    5"));
    }

    @Test
    public void RegexIsNotValid() {
        Assert.assertFalse(validator.validateRegex("5  8 dfds 8  "));
    }

    @Test
    public void RadiusIsLessThanZero() {
        Assert.assertFalse(validator.validateRegex(" 1  2  3  -5"));
    }
}
