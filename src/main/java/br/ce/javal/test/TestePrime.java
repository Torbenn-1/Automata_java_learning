package br.ce.javal.test;
import br.ce.javal.page.CampoTreinamentoPage;
import br.ce.javal.core.DSL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestePrime {

    private WebDriver driver;
    private DSL dsl;
    private CampoTreinamentoPage page;

    @Before
    // vai ser o comando executado uma vez antes de cada teste
    public void driver_starter_call(){
        // no need to "WebDriver driver = new ChromeDriver();"
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");

        page = new CampoTreinamentoPage();

    }

    @After
    public void driver_end(){
        driver.quit();
    }

    @Test
    public void deveinteragircomradiodetelanovaprime(){
        driver.findElement(By.xpath("//*[@id=\"j_idt311:option_label\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"j_idt311:option_items\"]//li[.='Option1']")).click();

    }


}


