package e2e;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import com.universidad.pruebas.PruebasApplication;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT, classes = PruebasApplication.class)
class TareasE2ETest {
    private WebDriver driver;
    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--headless", "--no-sandbox");
        driver = new ChromeDriver(opts);
        driver.get("http://localhost:8080/tareas");
    }
    @Test
    void paginaTareas_cargaCorrectamente() {
        assertThat(driver.getTitle()).contains("Tareas");
    }
    @AfterEach
    void tearDown() { if (driver != null) driver.quit(); }
}

