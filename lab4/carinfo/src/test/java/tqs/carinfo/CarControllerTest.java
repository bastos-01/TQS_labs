package tqs.carinfo;

import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarController.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarManagerService carManagerService;

    @Test
    public void whenPostCar_thenReturnCar() throws Exception {
        Car car = new Car("Nissan", "Skyline");


        when(carManagerService.save(Mockito.any())).thenReturn(car);

        mvc.perform(post("/api/newcar").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(car)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.maker", is("Nissan")))
                .andExpect(jsonPath("$.model", is("Skyline")));

        verify(carManagerService, times(1)).save(Mockito.any());
    }


    @Test
    public void whenGetCar_thenReturnJsonArray() throws Exception {

        Car car = new Car("Nissan", "GT-R");

        given( carManagerService.getCarDetails("GT-R")).willReturn(car);

        mvc.perform(get("/api/car").contentType(MediaType.APPLICATION_JSON).param("model", "GT-R"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.maker", is("Nissan")))
                .andExpect(jsonPath("$.model", is("GT-R")));

        verify(carManagerService, VerificationModeFactory.times(1)).getCarDetails("GT-R");

        reset(carManagerService);
    }
}
