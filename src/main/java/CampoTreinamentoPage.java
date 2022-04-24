import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CampoTreinamentoPage {

    private WebDriver driver;
    private DSL dsl = new DSL(driver);

    public CampoTreinamentoPage(WebDriver driver){
        dsl = new DSL(driver);
    }
    //=========================== ESCRITA DE TESTE =============================
    public void sugest(){
        dsl.escreve("elementosForm:sugestoes", "teste");
    }
    //=========================== FRAMES E WINDOWS =============================
    public void fram1(){

        dsl.frame1("frameButton");
       //dsl.frame2("frame1");

    }
    public void setEsportes(String... valores) {
        for (String valor : valores)
            dsl.comboSelect("elementosForm:esportes", valor);


    }
    public void windowHandlesTerminal(){
        dsl.windowshandles();

    }
    //=========================== ALERTAS E POPUPS =============================
    public String textoAlert(){
        return dsl.textoAlerta();
    }
    public String texto_alert_dismiss() {
        return dsl.texto_alert_dismiss();
    }
    public String texto_alert_accept() {
        return dsl.texto_alert_accept();
    }

    //=========================== BOTÕES E AÇÕES =============================
    public void cadastrar(){

        dsl.marca_clica("ElementosForm:cadastrar");
    }
    public void PopUpHard(){

        dsl.marca_clica("buttonPopUpHard");
    }
    public void PopUpEasy(){

        dsl.marca_clica("buttonPopUpEasy");
    }
    public void buttonSimples(){

        dsl.buttonSimples();

    }
    public String buttonSimplesTexto(){
        return dsl.buttonSimplesTexto();

    }
    public void voltar(){

        dsl.marca_link("Voltar");
    }
    public void alert_click(){
        dsl.marca_clica("alert");
    }
    public void frameButton(){
        dsl.frame1("frameButton");
        dsl.frame2("frame1");

    }
    public void prompt(){

        dsl.marca_clica("prompt");
    }
    public void confirm(){

        dsl.marca_clica("confirm");
    }

    //================================ NOMES ====================================


    public void setNome(String nome){

        dsl.escreve("elementosForm:nome", nome);
    }


    public void setSobrenome(String sobrenome){

        dsl.escreve("elementosForm:sobrenome",sobrenome);

    }
    //================================ SEXO ====================================

    public void setSexoMasc(){
        dsl.marca_clica("elementosForm:sexo:0");
    }
    public void setSexoFem(){
        dsl.marca_clica("elementosForm:sexo:1");
    }
    //=========================== COMIDA FAVORITA =============================

    public void ComidaFavoritaCarne(){
        dsl.marca_clica("elementosForm:comidaFavorita:0");
    }
    public void ComidaFavoritaFrango(){
        dsl.marca_clica("elementosForm:comidaFavorita:1");
    }
    public void ComidaFavoritaPizza(){
        dsl.marca_clica("elementosForm:comidaFavorita:2");
    }
    public void ComidaFavoritaVegetariano(){
        dsl.marca_clica("elementosForm:comidaFavorita:3");
    }
    //=========================== ESCOLARIDADE =============================
    public void primeiroGrauincompleto(){
        dsl.comboSelectByIndex(1, "elementosForm:escolaridade");
    }
    public void primeiroGrauCompleto(){
        dsl.comboSelectByIndex(2, "elementosForm:escolaridade");
    }
    public void segundoGrauIncompleto(){
        dsl.comboSelectByIndex(3, "elementosForm:escolaridade");
    }

    public void Superior(){
        dsl.comboSelectByIndex(4, "elementosForm:escolaridade");
    }

    public void Especializacao(){
        dsl.comboSelectByIndex(5, "elementosForm:escolaridade");
    }
    public void Mestrado(){
        dsl.comboSelectByIndex(6, "elementosForm:escolaridade");
    }

    public void Doutorado(){
        dsl.comboSelectByIndex(7, "elementosForm:escolaridade");
    }
    //=========================== ESPORTES =============================
    public void natacao(){
        dsl.esportes("Natacao");
    }

    public void futebol(){
        dsl.esportes("Futebol");
    }
    public void corrida(){
        dsl.esportes("Corrida");
    }
    public void karate(){
        dsl.esportes("Karate");
    }
    public void O_que_eh_esporte(){
        dsl.esportes("O que eh esporte?");
    }
//=========================== CHECK CADASTRO =============================
    public String findnomevali(){
        return dsl.findbyxpath("//*[@id=\"descNome\"]/span");
    }
    public String sobrenomevali(){
        return dsl.findbyxpath("//*[@id=\"descSobrenome\"]/span");
    }
    public String sexovali(){
        return dsl.findbyxpath("//*[@id=\"descSexo\"]/span");
    }
    public String comidavali(){
        return dsl.findbyxpath("//*[@id=\"descComida\"]/span");
    }
    public String estudovali(){
        return dsl.findbyxpath("//*[@id=\"descEscolaridade\"]/span");
    }
    public String esportesvali(){
        return dsl.findbyxpath("//*[@id=\"descEsportes\"]/span");
    }









    public String getTextAtributeSugestoes(){
        return dsl.get_text_atribute("elementosForm:sugestoes");
    }
    //=========================== RADIOS =============================





    public Boolean isSexMasc(){
        return dsl.isRadioCheck("elementosForm:sexo:0");
    }
    public Boolean isSexFem(){
        return dsl.isRadioCheck("elementosForm:sexo:1");
    }
    public Boolean isPizzaCheck(){
        return dsl.isRadioCheck("elementosForm:comidaFavorita:2");
    }
    public Integer tamanhoEscolaridade(){
        return dsl.comboSize("elementosForm:escolaridade");
    }
    public Integer tamanhoEsportes(){
        return dsl.comboSize("elementosForm:esportes");
    }
    public String current_atribute(){
        return dsl.get_text_atribute("elementosForm:nome");
    }
    public String h3(){
        return dsl.findbyTagName("h3");
    }
    public String ClassName(){
        return dsl.findByClassName("facilAchar");
    }
    public void window_handle_write(){
        dsl.find_window_id("textarea","deu certo! :D");
        dsl.find_window_id1("textarea","E agora?");
    }
    public boolean mestrado_existe(){
        return dsl.se_valor_existe_escolaridade("elementosForm:escolaridade","Mestrado");
    }
}
