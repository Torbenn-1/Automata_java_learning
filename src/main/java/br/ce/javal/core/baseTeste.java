package br.ce.javal.core;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static br.ce.javal.core.DriveFactory.getDriver;

public class baseTeste {


    @Rule
    public TestName testName = new TestName();

    @After
    public void driver_end() throws IOException {
        TakesScreenshot ss = (TakesScreenshot) getDriver();
        File arquivos = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivos, new File ("target" + File.separator + testName.getMethodName() + ".jpg"));
        if (propriedades.FECHAR_BROWSER) {
            DriveFactory.killDriver();

        }
    }


}
