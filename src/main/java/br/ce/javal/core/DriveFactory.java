package br.ce.javal.core;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static br.ce.javal.core.propriedades.Browsers.CHROME;
import static br.ce.javal.core.propriedades.Browsers.FIREFOX;


//cria apenas um driver
public class DriveFactory {
    private static WebDriver driver;
    private DriveFactory(){}

    public static WebDriver getDriver(){
        if(driver == null){
            driver = new ChromeDriver();

        }
        return driver;

    }
    public static void killDriver(){
        if(driver != null){

            driver.quit();
            driver = null;

        }
    }
}