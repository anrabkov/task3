package test.rabkov.task3.observer;

import com.rabkov.task3.creator.SphereInitializer;
import com.rabkov.task3.entity.ParametersOfSphere;
import com.rabkov.task3.entity.Point;
import com.rabkov.task3.entity.Sphere;
import com.rabkov.task3.exception.SphereException;
import com.rabkov.task3.observer.impl.SphereObserverImpl;
import com.rabkov.task3.warehouse.impl.SphereWarehouse;
import org.junit.Assert;
import org.testng.annotations.Test;

public class SphereObserverImplTest {

    @Test
    public void changeWarehouse() throws SphereException {
        Sphere sphere = new Sphere(new Point(5, 5, 5), 10);
        sphere.attachObserver(new SphereObserverImpl());
        SphereInitializer sphereInitializer = new SphereInitializer();
        sphereInitializer.initializeRepository(sphere);
        sphereInitializer.initializeWarehouse(sphere);
        SphereWarehouse warehouse = SphereWarehouse.getInstance();

        ParametersOfSphere originalParameters = warehouse.get(sphere.getSphereId()).get().clone();
        sphere.setRadius(1);
        ParametersOfSphere newParameters = warehouse.get(sphere.getSphereId()).get();

        Assert.assertNotEquals(originalParameters, newParameters);
    }
}
