import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.URL;

import java.util.concurrent.TimeUnit;


public class ApplyAsDeveloperTest {
    WebDriver driver;

    @BeforeEach
    public void setup(){
        //use FF Driver
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void applyAsDeveloper() {
        //Create object of HomePage Class
        HomePage home = new HomePage(driver);

        assertTrue(home.isPageOpened());

        home.clickOnDeveloperApplyButton();

        //Create object of DeveloperApplyPage
        DeveloperApplyPage apply_page =new DeveloperApplyPage(driver);

        //Check if page is opened
        assertTrue(apply_page.isPageOpened());

        //Fill up data
        apply_page.setDeveloper_email("dejan@toptal.com");
        apply_page.setDeveloper_full_name("Dejan Zivanovic Automated Test");
        apply_page.setDeveloper_password("password123");
        apply_page.setDeveloper_password_confirmation("password123");


        //Click on join
        //applyPage.clickOnJoin();
    }

    @AfterEach
    public void close(){
        driver.close();
    }


}
