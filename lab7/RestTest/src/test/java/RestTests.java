import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.RestAssured.*;

public class RestTests {

    @Test
    void endpointStatus200Test(){
        given().when().get("https://jsonplaceholder.typicode.com/todos").then().assertThat().statusCode(200);
    }

    @Test
    void TitleOfTodoTest() {
        given().when().get("https://jsonplaceholder.typicode.com/todos/4").then().assertThat()
                .body("title", equalTo("et porro tempora"));

    }

    @Test
    void AllTodosReturn198And199Test() {
        given().when().get("https://jsonplaceholder.typicode.com/todos").then().assertThat().body("id", hasItems(198, 199));
    }


}
