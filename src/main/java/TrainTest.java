import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class TrainTest {
    // as global var
    private WebDriver driver;
    private DSL dsl;
    private CampoTreinamentoPage page;

    @Before
    // vai ser o comando executado uma vez antes de cada teste
    public void driver_starter_call(){
        // no need to "WebDriver driver = new ChromeDriver();"
        driver = new ChromeDriver();
        driver.manage().window().minimize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        dsl = new DSL(driver);
        page = new CampoTreinamentoPage(driver);

    }

    @After
    public void driver_end(){
        driver.quit();
    }


// começo de testes
    @Test
    public void XpathnomeTF(){
        dsl.xpathnomeset();

    }
    @Test
    public void Xpathradiosexfem(){
        dsl.sexfemxpth();
    }

    @Test
    public void findlabelXpath(){
        dsl.findLabelxpath();

    }

    @Test
    public void doutorado () {
        dsl.comboSelectByIndexpath("Doutorado");


    }
    @Test
    public void Superior () {
        dsl.comboSelectByIndexpath("Superior");


    }

    @Test
    public void mariaXpath(){

        dsl.mariafindXpath();
        dsl.textoAlerta();

    }

    @Test
    public void Escrita_em_nome() {

        page.setNome("Piter");
        Assert.assertEquals("Piter",page.current_atribute());

    }

    @Test
    public void testetextarea() {
        System.getProperty("user.id");
        page.sugest();
        Assert.assertEquals("teste", page.getTextAtributeSugestoes());

    }

    @Test
    public void testradio() {

        page.setSexoMasc();
        Assert.assertTrue(page.isSexMasc());
    }

    @Test
    public void testcheck() {
        page.ComidaFavoritaPizza();
        Assert.assertTrue(page.isPizzaCheck());
    }

    @Test
    public void verificarcombo() {


        page.Superior();
        Assert.assertEquals("Superior",dsl.comboGetTextFirst("elementosForm:escolaridade"));
    }

    @Test
    public void tamanho_combo_escolaridade() {

        String encontrou = String.valueOf(page.mestrado_existe());
        Assert.assertTrue(Boolean.parseBoolean(encontrou));

    }


    @Test
    public void teste_valor_combo_multi() {


        page.natacao();
        page.corrida();
        page.O_que_eh_esporte();


        String a = String.valueOf(page.tamanhoEsportes());
        Assert.assertEquals("3", a);

    }

    @Test
    public void deve_interagir_com_buttons() {
        page.buttonSimples();
        Assert.assertEquals("Obrigado!", page.buttonSimplesTexto());

    }

    @Test
    @Ignore
    //@Ignore ignora o teste atual passando por ele sem executar
    public void elemento_por_tag() {
        WebElement voltar = driver.findElement(By.id("resultado"));
        //Assert.assertEquals("Obrigado!", button.getAttribute("value"));
        Assert.assertEquals("Voltou!", voltar.getAttribute("value"));
    }

    //funciona mas, não é muito performático
    @Test
    public void elemento_sem_id() {

        Assert.assertEquals("Campo de Treinamento", page.h3());
        // existe também a busca por classes
        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", page.ClassName());

    }

    @Test
    public void voltar_validacao() {
        page.voltar();

        Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
    }

    @Test

    public void validacao_alert_simples_call() {
        page.alert_click();
        String texto = page.texto_alert_accept();
        page.setNome("teste");
        Assert.assertEquals("Alert Simples", texto);


    }

    @Test
    public void validacao_alert_accept() {
        driver.findElement(By.id("confirm")).click();

        Assert.assertEquals("Confirm Simples", page.texto_alert_accept());
    }

    @Test
    public void validacao_alert_dismiss() {
        page.confirm();
        Assert.assertEquals("Negado", page.texto_alert_dismiss());


    }

    @Test
    public void validacao_alert_prompt() {
        page.prompt();

        // All good
        Alert alerta = driver.switchTo().alert();
        Assert.assertEquals("Digite um numero", alerta.getText());
        alerta.sendKeys("12");
        alerta.accept();
        Assert.assertEquals("Era 12?", alerta.getText());
        alerta.accept();
        Assert.assertEquals(":D", alerta.getText());
        alerta.accept();


        //alert bad ending with not null
        page.prompt();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Digite um numero", alerta.getText());
        alert.sendKeys("12");
        alert.accept();
        Assert.assertEquals("Era 12?", alert.getText());
        alert.dismiss();
        Assert.assertEquals(":(", alert.getText());
        alert.accept();

        page.prompt();
        Alert alertabad = driver.switchTo().alert();
        Assert.assertEquals("Digite um numero", alertabad.getText());
        alertabad.dismiss();
        Assert.assertEquals("Era null?", alertabad.getText());
        alertabad.dismiss();
        Assert.assertEquals(":(", alertabad.getText());


    }

    @Test
    public void validacao_cadastro() {
        page.setNome("Piter");
        page.setSobrenome("Dixon");
        page.setSexoMasc();
        page.ComidaFavoritaPizza();
        page.Mestrado();
        page.natacao();
        page.corrida();
        page.cadastrar();

        Assert.assertEquals("Piter", page.findnomevali());
        Assert.assertEquals("Dixon", page.sobrenomevali());
        Assert.assertEquals("Masculino", page.sexovali());
        Assert.assertEquals("Pizza", page.comidavali());
        Assert.assertEquals("mestrado", page.estudovali());
        Assert.assertEquals("Natacao Corrida", page.esportesvali());



    }

    @Ignore
    @Test
    public void find_in_frame() {

        page.fram1();
        Assert.assertEquals("Frame OK!", page.textoAlert());
    }

    @Test
    public void find_window() {
        page.PopUpEasy();

        driver.switchTo().window("Popup");
        driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
        // para retornar para a popup
        driver.close();
        driver.switchTo().window("");
        driver.findElement(By.tagName("textarea")).sendKeys("E agora?");

    }
// teste de window handler para quando não existe nome na janela e não está facil de achar
    @Test
    public void find_window_id() {
        page.PopUpHard();
        // vai encontrar o "id" da janela
        page.windowHandlesTerminal();

        page.window_handle_write();
    }
    @Test
    public void validacao_regras_de_negocio_nome(){
        //nome, sobrenome e sexo obrigatórios: não pode ser vegetáriano com carne como comida favorita
        //não pode ter um esporte e perguntar o que é esporte
        page.setNome("");
        page.cadastrar();


        Assert.assertEquals("Nome eh obrigatorio", page.textoAlert());

    }
    @Test
    public void validacao_regras_de_negocio_sobrenome() {
        page.setSobrenome("");
        page.setNome("just a test name");
        page.cadastrar();

        Assert.assertEquals("Sobrenome eh obrigatorio", page.textoAlert());

    }
    @Test
    public void validacao_regras_de_negocio_Sexo() {
        page.setNome("just a teste name");
        page.setSobrenome("just a test name");
        page.ComidaFavoritaCarne();
        page.ComidaFavoritaPizza();
        page.cadastrar();


        Assert.assertEquals("Sexo eh obrigatorio", page.textoAlert());


    }
    @Test
    public void validacao_regras_de_negocio_alimetacao() {

        page.setNome("Piter");
        page.setSobrenome("Dixon");
        page.ComidaFavoritaCarne();
        page.setSexoMasc();
        page.ComidaFavoritaVegetariano();
        page.cadastrar();
        Assert.assertEquals("Tem certeza que voce eh vegetariano?", page.texto_alert_accept());


    }
    @Test
    public void testJS(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('TestandoJS via selenium')");
    }
    @Test
    public void JSelemento(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('elementosForm:nome').value = 'write something'");
        //js.executeScript("document.getElementById('elementosForm:nome').type = 'radio'");

        WebElement element = driver.findElement(By.id("elementosForm:nome"));
        js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");

    }
@Test
    public void clicarbuttontabela(){
        dsl.clicarBotaoTabela("Escolaridade","Mestrado", "Radio", "elementosForm:tableUsuarios");
    }
    @Test
    public void teste_de_reducao() {
        driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[8]/td[2]/table/tbody/tr[3]/td[5]/table/tbody/tr/td/input")).click();
    }
}