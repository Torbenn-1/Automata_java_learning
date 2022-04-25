package br.ce.javal.test;

import br.ce.javal.core.DSL;
import br.ce.javal.core.DriveFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import br.ce.javal.page.CampoTreinamentoPage;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class SleepSyncro {

    private WebDriver driver;
    private DSL dsl;
    private CampoTreinamentoPage page;

    @Before
    // vai ser o comando executado uma vez antes de cada teste
    public void driver_starter_call(){
        // no need to "WebDriver driver = new ChromeDriver();"

        DriveFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        dsl = new DSL();
        page = new CampoTreinamentoPage();

    }

    @After
    public void driver_end(){
        //driver.quit();
    }


    @Test
    public void deve_interagir_com_resposta_demorada(){
        dsl.marca_clica("buttonDelay");
        try
        {
            Thread.sleep(6000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }        dsl.escreve("novoCampo","Try");
    }
    @Test
    public void deve_interagir_com_resposta_demorada_com_timer_ajustado(){
        dsl.marca_clica("buttonDelay");
        //liga a espera
        DriveFactory.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        dsl.escreve("novoCampo","Try");
        // desliga a espera
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

    } @Test
    public void deve_interagir_com_resposta_demorada_com_timer_ajustado_espera_implicita() throws InterruptedException{
        dsl.marca_clica("buttonDelay");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
        dsl.escreve("novoCampo", "Deu Certo?");
    }

}
