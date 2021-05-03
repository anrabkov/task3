package test.rabkov.task3.observer;

import com.rabkov.task3.creator.SphereInitializer;
import com.rabkov.task3.entity.ParametersOfSphere;
import com.rabkov.task3.entity.Point;
import com.rabkov.task3.entity.Sphere;
import com.rabkov.task3.exception.SphereException;
import com.rabkov.task3.observer.impl.SphereObserverImpl;
import com.rabkov.task3.warehouse.impl.SphereWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.Test;

public class SphereObserverImplTest {
    Logger logger = LogManager.getLogger();



    @Test
    public void changeWarehouse() throws SphereException {
        Sphere sphere = new Sphere(new Point(5,5,5),10);
        logger.info("Radius of the sphere before change: radius = " + sphere.getRadius());
        sphere.attachObserver(new SphereObserverImpl());
        SphereInitializer sphereInitializer = new SphereInitializer();
        sphereInitializer.initializeRepository(sphere);
        sphereInitializer.initializeWarehouse(sphere);
        SphereWarehouse warehouse = SphereWarehouse.getInstance();

        ParametersOfSphere originalParameters = warehouse.get(sphere.getSphereId()).orElse(new ParametersOfSphere());
        logger.info("Parameters of the sphere before change the radius: surfaceArea = "+ originalParameters.getSurfaceArea()
                + ", volume = " + originalParameters.getVolume());
        sphere.setRadius(1);
        logger.info("Radius of the sphere after change: radius = " + sphere.getRadius());
        ParametersOfSphere newParameters = warehouse.get(sphere.getSphereId()).get();
        logger.info("Parameters of the sphere after change the radius: surfaceArea = "+ originalParameters.getSurfaceArea()
                + ", volume = " + originalParameters.getVolume());

        Assert.assertEquals(originalParameters, newParameters);
    }
}
