package test.rabkov.task3.serviceTest;

import com.rabkov.task3.entity.Point;
import com.rabkov.task3.entity.Sphere;
import com.rabkov.task3.exception.SphereException;
import com.rabkov.task3.service.CalculationService;
import com.rabkov.task3.service.iml.CalculationServiceIml;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculationServiceTest {

    private CalculationService calculationService;

    @BeforeClass
    public void SetUp() {
        calculationService = new CalculationServiceIml();
    }

    @Test(dataProvider = "surface-area-provider")
    public void calculateAreaTest(Sphere sphere, double expectedArea) {
        double actualArea = calculationService.calculateSurfaceArea(sphere);

        Assert.assertEquals(actualArea, expectedArea);
    }

    @DataProvider(name = "surface-area-provider")
    public Object[][] calculateArea() throws SphereException {
        return new Object[][]{
                {new Sphere(new Point(1, 1, 1), 2), 4 * Math.PI * Math.pow(2, 2)},
                {new Sphere(new Point(2, 1, 2), 1), 4 * Math.PI * Math.pow(1, 2)}
        };
    }


    @Test(dataProvider = "volume-provider")
    public void calculateVolumeTest(Sphere sphere, double expectedVolume) {
        double actualVolume = calculationService.calculateVolume(sphere);
        Assert.assertEquals(actualVolume, expectedVolume);
    }

    @DataProvider(name = "volume-provider")
    public Object[][] calculateVolume() throws SphereException {
        return new Object[][]{
                {new Sphere(new Point(1, 3, 5), 5), 4 / 3 * Math.PI * Math.pow(5, 3)},
                {new Sphere(new Point(1, 3, 2), 1.24), 4 / 3 * Math.PI * Math.pow(1.24, 3)},
                {new Sphere(new Point(1, 6, 2), 25), 4 / 3 * Math.PI * Math.pow(25, 3)},
        };
    }

}


