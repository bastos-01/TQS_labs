package tqs.carinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CarController {
    @Autowired
    private CarManagerService carManagerService;

    @PostMapping("/newcar")
    public ResponseEntity<Car> createCar(@RequestBody Car c) {
        HttpStatus status = HttpStatus.CREATED;
        Car savedCar = carManagerService.save(c);

        return new ResponseEntity<>(savedCar, status);
    }

    @GetMapping("/car")
    public Car getCarDetails(@RequestParam(name = "model") String model) {
        return carManagerService.getCarDetails(model);
    }
}
