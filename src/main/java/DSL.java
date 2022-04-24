//Um dsl serve para facilitar/padronizar e normalizar funções visando dry code
//assim temos um código no qual não devemos ficar nos repetindo como por exemplo
//ficar escrevendo o mesmo assert para várias funções, mas vale lembrar deve sempre
//ser instaciado o driver como uma instancia genéricae global


import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DSL {


    // instancia do driver
    public WebDriver driver;

    public DSL(WebDriver driver) {
        super();
        this.driver = driver;


    }

    public void escreve(String id_driver, String insert_data) {

        driver.findElement(By.id(id_driver)).sendKeys(insert_data);

    }

    public void marca_clica(String id_driver) {

        driver.findElement(By.id(id_driver)).click();
    }

    public void marca_link(String id) {
        driver.findElement(By.linkText(id)).click();

    }

    public String get_text_atribute(String id_campo) {
        return driver.findElement(By.id(id_campo)).getAttribute("value");

    }

    public String buttonSimplesTexto() {
        WebElement button = driver.findElement(By.id("buttonSimple"));
        button.click();
        return button.getAttribute("value");
    }

    public void buttonSimples() {
        WebElement button = driver.findElement(By.id("buttonSimple"));
        button.click();
    }

    public void alert_dismiss() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public boolean isRadioCheck(String id_campo) {
        return driver.findElement(By.id(id_campo)).isSelected();

    }

    public void comboSelect(String id, String valor) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }
    public void comboSelectxpath(String xpath, String valor) {
        WebElement element = driver.findElement(By.id(xpath));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }
    public String esp(String id_esportes) {
        return driver.findElement(By.id(id_esportes)).getText();
    }

    // ====================COMBO OPTIONS ====================
    public String comboGetTextFirst(String id) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();

    }
    // ====================Xpath learning ====================

    public void xpathnomeset() {
        driver.findElement(By.xpath("//*[@id=\"elementosForm:nome\"]")).sendKeys("testexpath");

    }

    public void mariafindXpath() {
        driver.findElement(By.xpath("//*[@id=\"elementosForm:tableUsuarios\"]/tbody/tr[2]/td[3]/input")).click();

    }

    public void sexfemxpth() {
        driver.findElement(By.xpath("//*[@id=\"elementosForm:sexo:1\"]")).click();

    }

    public void findLabelxpath() {
        driver.findElement(By.xpath("//*[@id=\"elementosForm:comidaFavorita\"]/tbody/tr/td[3]/label"));

    }

    public int comboSize(String id) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getAllSelectedOptions().size();
    }

    public void comboSelectByIndex(Integer index, String id_campo) {
        WebElement element = driver.findElement(By.id(id_campo));
        Select comboeIndex = new Select(element);
        comboeIndex.selectByIndex(index);

    }

    public void comboSelectByIndexpath(String name) {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"elementosForm:escolaridade\"]"));
        Select comboeIndex = new Select(element);
        comboeIndex.selectByVisibleText(name);

    }


//============================== SPORT HANDLE ==============================

    public void esportes(String texto) {
        WebElement elementoesporte = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(elementoesporte);
        combo.selectByVisibleText(texto);
    }


    //============================== ALERT HANDLE ==============================


    public String textoAlerta() {
        Alert alerta = driver.switchTo().alert();
        return alerta.getText();

    }

    public void selecaoCombo(String id, String valor) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText((valor));

    }

    public String texto_alert_dismiss() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        return alert.getText();
    }

    public String texto_alert_accept() {
        Alert alert = driver.switchTo().alert();
        String a = alert.getText();
        alert.accept();
        return a;
    }

    //==============================COMBO ESCOLARIDADE==============================
    public void windowshandles() {
        System.out.println("Id da janela atual");
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getWindowHandles());
    }

    //==============================COMBO ESCOLARIDADE==============================
    public Integer checkTamanhoEscolaridade() {
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        return options.size();

    }

    public String atributefromid(String id_atributo) {
        WebElement voltar = driver.findElement(By.id(id_atributo));
        return voltar.getAttribute("value");
    }
//==============================CHECK CADASTRO==============================


    public String getCurrentText(String id_campo) {

        return driver.findElement(By.id(id_campo)).getText();
    }

    public String getTextByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public String findbyTagName(String tag_campo) {
        return driver.findElement(By.tagName(tag_campo)).getText();
    }

    public String findByClassName(String class_name) {
        return driver.findElement(By.className(class_name)).getText();
    }


    //==============================FRAME OPTIONS==============================
    public void frame1(String id_frame_button) {
        driver.findElement(By.id(id_frame_button)).click();
    }

    public void frame2(String id_current_frame) {
        driver.switchTo().frame(id_current_frame);
    }

    public void find_window_id(String id_text, String key_to_send) {
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
        driver.findElement(By.tagName(id_text)).sendKeys(key_to_send);
    }

    public void find_window_id1(String id_text, String key_to_send) {
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
        driver.findElement(By.tagName(id_text)).sendKeys(key_to_send);
    }

    public boolean se_valor_existe_escolaridade(String id_existe, String valor_check) {
        WebElement element = driver.findElement(By.id(id_existe));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        Assert.assertEquals(8, options.size());


        //checando se o valor existe na combobox
        boolean encontrou = false;
        for (WebElement option : options) {
            if (option.getText().equals(valor_check)) {
                encontrou = true;
                break;
            }
        }

        return encontrou;
    }
    //##################### metoodos de tabela


    public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
        //procurar coluna do registro
        WebElement tabela = driver.findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));
        int idColuna = obterIndiceColuna(colunaBusca, tabela);

        //encontrar a linha do registro
        int idLinha = obterIndiceLinha(valor, tabela, idColuna);

        //procurar coluna do botao
        int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);

        //clicar no botao da celula encontrada
        WebElement celula = tabela.findElement(By.xpath(".//tr[" + idLinha + "]/td[" + idColunaBotao + "]"));
        celula.findElement(By.xpath(".//input")).click();

    }

    protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
        List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td[" + idColuna + "]"));
        int idLinha = -1;
        for (int i = 0; i < linhas.size(); i++) {
            if (linhas.get(i).getText().equals(valor)) {
                idLinha = i + 1;
                break;
            }
        }
        return idLinha;
    }

    protected int obterIndiceColuna(String coluna, WebElement tabela) {
        List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
        int idColuna = -1;
        for (int i = 0; i < colunas.size(); i++) {
            if (colunas.get(i).getText().equals(coluna)) {
                idColuna = i + 1;
                break;
            }
        }
        return idColuna;
    }

    public String findbyxpath(String xpath) {
        return driver.findElement(By.xpath(xpath)).getText();


    }
    public void clicarradioexterno(String xpath ){
        driver.findElement(By.xpath(xpath)).click();
    }
}
