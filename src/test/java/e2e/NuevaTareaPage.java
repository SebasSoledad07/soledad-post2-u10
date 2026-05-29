package e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NuevaTareaPage {
    private final WebDriver driver;
    private final By inputTitulo = By.id("titulo");
    private final By inputDescripcion = By.id("descripcion");
    private final By btnGuardar = By.id("btn-guardar");

    public NuevaTareaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setTitulo(String titulo) {
        WebElement e = driver.findElement(inputTitulo);
        e.clear();
        e.sendKeys(titulo);
    }

    public void setDescripcion(String descripcion) {
        WebElement e = driver.findElement(inputDescripcion);
        e.clear();
        e.sendKeys(descripcion);
    }

    public TareasPage guardar() {
        driver.findElement(btnGuardar).click();
        return new TareasPage(driver);
    }

    public TareasPage crearTarea(String titulo, String descripcion) {
        setTitulo(titulo);
        setDescripcion(descripcion);
        return guardar();
    }
}

