package test.rabkov.task3.repository;


import com.rabkov.task3.comparator.SphereComparator;
import com.rabkov.task3.entity.Point;
import com.rabkov.task3.entity.Sphere;
import com.rabkov.task3.exception.SphereException;
import com.rabkov.task3.repository.Specification;
import com.rabkov.task3.repository.iml.SphereRepositoryIml;
import com.rabkov.task3.repository.iml.IdSpecification;
import com.rabkov.task3.repository.iml.RadiusSpecification;
import com.rabkov.task3.repository.iml.SurfaceAreaSpecification;
import com.rabkov.task3.repository.iml.VolumeSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.*;
import java.util.stream.Collectors;

public class SphereRepositoryTest {

    private SphereRepositoryIml repository;
    private Sphere sphere1;
    private Sphere sphere2;
    private Sphere sphere3;
    private Sphere sphere4;
    private Sphere sphere5;

    @BeforeClass
    public void SetUp() throws SphereException {
        repository = SphereRepositoryIml.getInstance();
        sphere1 = new Sphere(new Point(1, 1, 1), 5.5);
        sphere2 = new Sphere(new Point(1, 1, 1), 2.78);
        sphere3 = new Sphere(new Point(1, 1, 1), 100);
        sphere4 = new Sphere(new Point(1, 1, 1), 55);
        sphere5 = new Sphere(new Point(1, 1, 1), 60.2);

        repository.add(sphere1);
        repository.add(sphere2);
        repository.add(sphere3);
        repository.add(sphere4);
        repository.add(sphere5);
    }

    @Test(dataProvider = "specification-provider")
    public void queryTest(Specification specification, Sphere[] expectedSpheres) {
        List<Sphere> actualList;
        actualList = repository.query(specification);
        List<Sphere> expectedList = Arrays.stream(expectedSpheres).collect(Collectors.toList());

        Assert.assertEquals(actualList, expectedList);
    }

    @DataProvider(name = "specification-provider")
    public Object[][] specificationProvider() {
        return new Object[][]{
                {new IdSpecification(2), new Sphere[]{sphere2}},
                {new RadiusSpecification(50, 2), new Sphere[]{sphere1, sphere2}},
                {new VolumeSpecification(5000000, 10000), new Sphere[]{sphere3, sphere4, sphere5}},
                {new SurfaceAreaSpecification(100, 10), new Sphere[]{sphere2}},
        };
    }


    @Test(dataProvider = "sort-provider")
    public void sortProvider(SphereComparator comparator, Sphere[] expectedSpheres) {
        List<Sphere> actualList = repository.sort(comparator);
        List<Sphere> expectedList = Arrays.stream(expectedSpheres).collect(Collectors.toList());

        Assert.assertEquals(actualList, expectedList);
    }

    @DataProvider(name = "sort-provider")
    public Object[][] sortComparator() {
        return new Object[][]{
                {SphereComparator.ID_COMPARATOR, new Sphere[]{sphere1, sphere2, sphere3, sphere4, sphere5}},
                {SphereComparator.RADIUS_COMPARATOR, new Sphere[]{sphere2, sphere1, sphere4, sphere5, sphere3}},
                {SphereComparator.VOLUME_COMPARATOR, new Sphere[]{sphere2, sphere1, sphere4, sphere5, sphere3}},
                {SphereComparator.SURFACE_AREA_COMPARATOR, new Sphere[]{sphere2, sphere1, sphere4, sphere5, sphere3}}
        };
    }
}

