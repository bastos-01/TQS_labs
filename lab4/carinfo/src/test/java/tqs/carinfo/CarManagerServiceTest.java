package tqs.carinfo;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CarManagerServiceTest {

    @Mock(lenient = true)
    private CarRepository carRepository;

    @InjectMocks
    private CarManagerService carManagerService;

    @BeforeEach
    public void setUp() {
        Car car = new Car("Nissan", "GT-R");

        Mockito.when(carRepository.findByModel(car.getModel())).thenReturn(car);
        Mockito.when(carRepository.findByModel("not_a_model")).thenReturn(null);
    }

    @Test
    public void whenValidModel_thenCar() {

        String model = "GT-R";

        Car car = carManagerService.getCarDetails(model);

        assertThat(car.getModel()).isEqualTo(model);
    }

    @Test
    public void whenInvalidModel_thenNoCar() {

        Car car = carManagerService.getCarDetails("not_a_model");

        assertThat(car).isNull();

        Mockito.verify(carRepository, VerificationModeFactory.times(1)).findByModel("not_a_model");

        Mockito.reset(carRepository);
    }
}
