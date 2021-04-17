package tqs.carinfo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CarRepository carRepository;

    @Test
    public void whenFindByModel_thenCar() {

        Car car = new Car("Nissan", "Skyline");

        testEntityManager.persistAndFlush(car);

        Car response_car = carRepository.findByModel(car.getModel());

        assertThat(response_car.getModel()).isEqualTo(car.getModel());
    }

    @Test
    public void whenInvalidModel_thenNoCar() {

        Car car = carRepository.findByModel("not_a_model");

        assertThat(car).isNull();
    }
}
