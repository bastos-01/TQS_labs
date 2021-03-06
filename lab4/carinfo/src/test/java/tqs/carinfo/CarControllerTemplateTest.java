package tqs.carinfo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.io.IOException;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = CarinfoApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "application-integrationtest.properties")
public class CarControllerTemplateTest {

    @LocalServerPort
    int randomPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private CarRepository carRepository;

    @AfterEach
    public void resetDB() {
        carRepository.deleteAll();
    }

    @Test
    public void whenValidInputThenCreateCar() throws IOException, Exception{
        Car car = new Car("Nissan","GT-R");

        ResponseEntity<Car> entity = restTemplate.postForEntity("/api/newcar", car, Car.class);

        Car response_car = carRepository.findByModel(car.getModel());

        // verify
        assertThat(response_car.getModel()).isEqualTo(car.getModel());
    }

    @Test
    public void whenGetCarStatus200() throws Exception {

        Car car = new Car("Nissan","GT-R");

        carRepository.saveAndFlush(car);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:" + randomPort + "/api/car").queryParam("model", "GT-R");

        ResponseEntity<Car> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<Car>() {});

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getModel()).isEqualTo(car.getModel());
    }
}
