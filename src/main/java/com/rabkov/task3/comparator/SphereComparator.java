package com.rabkov.task3.comparator;

import com.rabkov.task3.entity.Sphere;
import com.rabkov.task3.service.CalculationService;
import com.rabkov.task3.service.impl.CalculationServiceIml;

import java.util.Comparator;

public enum SphereComparator implements Comparator<Sphere> {
    VOLUME_COMPARATOR {
        @Override
        public int compare(Sphere s1, Sphere s2) {
            CalculationService service = new CalculationServiceIml();
            int result = Double.compare(service.calculateVolume(s1), service.calculateVolume(s2));
            return result;
        }
    },
    RADIUS_COMPARATOR {
        @Override
        public int compare(Sphere s1, Sphere s2) {
            int result = Double.compare(s1.getRadius(), s2.getRadius());
            return result;
        }
    },
    ID_COMPARATOR {
        @Override
        public int compare(Sphere s1, Sphere s2) {
            int result = Double.compare(s1.getSphereId(), s2.getSphereId());
            return result;
        }
    },
    SURFACE_AREA_COMPARATOR {
        @Override
        public int compare(Sphere s1, Sphere s2) {
            CalculationService service = new CalculationServiceIml();
            int result = Double.compare(service.calculateSurfaceArea(s1), service.calculateSurfaceArea(s2));
            return result;
        }
    }
}
