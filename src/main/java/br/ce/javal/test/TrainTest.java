package br.ce.javal.test;
import br.ce.javal.core.baseTeste;
import br.ce.javal.core.DSL;
import static br.ce.javal.core.DriveFactory.getDriver;
import static br.ce.javal.core.DriveFactory.killDriver;

import br.ce.javal.core.DriveFactory;
import org.junit.*;
import org.openqa.selenium.*;
import br.ce.javal.page.CampoTreinamentoPage;

public class TrainTest extends baseTeste {
    // as global var
    private DSL dsl;
    private CampoTreinamentoPage page;

    @Before
    // vai ser o comando executado uma vez antes de cada teste
    public void driver_starter_call(){

        DriveFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        page = new CampoTreinamentoPage();

    }


// começo de testes
    @Test
    public void XpathnomeTF(){
        page.nomesetx();
    }
    @Test
    public void Xpathradiosexfem(){
        page.sexo_fem_radio_x();
    }

    @Test
    public void findlabelXpath(){
        page.labelxpathfind();
    }

    @Test
    public void doutorado () {
        page.doutorado_xpath();

    }
    @Test
    public void Superior () {
        page.superiorporindex();

    }

    @Test
    public void mariaXpath(){
        getDriver();
        page.mariaporxpath();

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
        Assert.assertEquals("Superior", page.primeiro_escolaridade());
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
        WebElement voltar = getDriver().findElement(By.id("resultado"));
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

        Assert.assertEquals("Voltou!", getDriver().findElement(By.id("resultado")).getText());
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
        getDriver().findElement(By.id("confirm")).click();

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
        Alert alerta = getDriver().switchTo().alert();
        Assert.assertEquals("Digite um numero", alerta.getText());
        alerta.sendKeys("12");
        alerta.accept();
        Assert.assertEquals("Era 12?", alerta.getText());
        alerta.accept();
        Assert.assertEquals(":D", alerta.getText());
        alerta.accept();


        //alert bad ending with not null
        page.prompt();
        Alert alert = getDriver().switchTo().alert();
        Assert.assertEquals("Digite um numero", alerta.getText());
        alert.sendKeys("12");
        alert.accept();
        Assert.assertEquals("Era 12?", alert.getText());
        alert.dismiss();
        Assert.assertEquals(":(", alert.getText());
        alert.accept();

        page.prompt();
        Alert alertabad = getDriver().switchTo().alert();
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

        getDriver().switchTo().window("Popup");
        getDriver().findElement(By.tagName("textarea")).sendKeys("Deu certo?");
        // para retornar para a popup
        getDriver().close();
        getDriver().switchTo().window("");
        getDriver().findElement(By.tagName("textarea")).sendKeys("E agora?");

    }
// teste de window handler para quando não existe nome na janela e não está facil de achar
    @Test
    public void find_window_id() {
        page.PopUpHard();
        // vai encontrar o "id" da janela
        page.windowHandlesTerminal();

        page.window_handle_write();
        killDriver();
        
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
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("alert('TestandoJS via selenium')");
    }
    @Test
    public void JSelemento(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("document.getElementById('elementosForm:nome').value = 'write something'");
        //js.executeScript("document.getElementById('elementosForm:nome').type = 'radio'");

        WebElement element = getDriver().findElement(By.id("elementosForm:nome"));
        js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");

    }
@Test
    public void clicarbuttontabela(){
        page.selecionarradiomestrado();
    }
    @Test
    public void teste_de_reducao() {
        getDriver().findElement(By.xpath("/html/body/center/form/table/tbody/tr[8]/td[2]/table/tbody/tr[3]/td[5]/table/tbody/tr/td/input")).click();
    }
}