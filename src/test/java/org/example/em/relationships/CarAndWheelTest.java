package org.example.em.relationships;

import com.example.model.Car;
import com.example.model.Wheel;
import org.example.em.EntityManagerTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
class CarAndWheelTest extends EntityManagerTest {


    @Test
    void shouldCreateCarAndWheels() {
        doInTransaction(em -> {
            Car car = Car.of(1, "Nissan", new ArrayList<Wheel>());

            Wheel wheel1 = Wheel.of(1, 1);
            Wheel wheel2 = Wheel.of(2, 1);

            car.addWheels(Arrays.asList(wheel1, wheel2));

            em.persist(car);

        });
    }

    @Test
    void shouldTransferHondaWheelsToNissan() {
        doInTransaction(em -> {
            Car car = Car.of(1, "Honda", new ArrayList<Wheel>());

            Wheel wheel1 = Wheel.of(1, 1);
            Wheel wheel2 = Wheel.of(2, 1);

            car.addWheels(Arrays.asList(wheel1, wheel2));

            em.persist(car);
        });

        doInTransaction(em -> {
            Car honda = em.find(Car.class, 1);
            List<Wheel> wheels = honda.getWheels();

            Car nissan = Car.of(2, "Nissan", new ArrayList<>());
            nissan.addWheels(new ArrayList<>(wheels));

            wheels.clear();

            em.persist(nissan);
        });

        doInTransaction(em -> {
            Car nissan = em.find(Car.class, 2);
            Car honda = em.find(Car.class, 1);

            List<Wheel> hondaWheels = honda.getWheels();

            List<Wheel> nissanWheels = nissan.getWheels();

            Assertions.assertEquals(hondaWheels.size(), 0);

            Assertions.assertNotNull(nissanWheels);
            Assertions.assertEquals(nissanWheels.size(), 2);
        });
    }
}
