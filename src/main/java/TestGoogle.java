import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import java.util.List;


public class TestGoogle {

    @Test
    public void validacao_completa() {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Piter");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Dixon");
        driver.findElement(By.id("elementosForm:sexo:0")).click();

        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        Assert.assertEquals(8, options.size());



        Assert.assertEquals("Piter", driver.findElement(By.id("descNome")).getText());
        Assert.assertEquals("Dixon", driver.findElement(By.id("descSobrenome")).getText());
        Assert.assertEquals("Masculino", driver.findElement(By.id("descsexo")).getText());
        Assert.assertEquals("Mestrado", driver.findElement(By.id("descEscolidade")).getText());



    }

}
