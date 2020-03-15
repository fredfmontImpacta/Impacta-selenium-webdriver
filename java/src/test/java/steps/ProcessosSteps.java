package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.MenuPage;
import pages.MostarProcessoPage;
import pages.ProcessoPage;
import pages.ProcessosPage;
import support.BaseSteps;
import definitions.Processo;

import java.util.concurrent.TimeUnit;

public class ProcessosSteps extends BaseSteps {

    private MenuPage menuPage = new MenuPage(driver);
    private ProcessosPage processosPage = new ProcessosPage(driver);
    private ProcessoPage novoProcessoPage = new ProcessoPage(driver);
    private MostarProcessoPage mostrarProcessoPage = new MostarProcessoPage(driver);

    @Given("^the user is in the Agapito Software testing page$")
    public void thatTheUserIsInTheAgapitoSoftwareTestingPage() {
        this.menuPage.abrirPagina();
    }

    @And("^the user clicks in the Processos menu option$")
    public void theUserClicksInTheProcessosMenuOption() {
        this.menuPage.clickProcessosMenuOption();
    }

    @And("^the user clicks in the Novo Processo button$")
    public void theUserClicksInTheNovoProcessoButton() {
        this.processosPage.clickNovoProcessoButton();
    }

    @And("^the user fills the value \"([^\"]*)\" to the \"([^\"]*)\" field in the Processo page$")
    public void theUserFillsTheValueToTheFieldInTheProcessoPage(String value, String field) throws Throwable {
       this.novoProcessoPage.fillField(value, field);
    }

    @When("^the user clicks in the \"([^\"]*)\" in the Processo page$")
    public void theUserClicksInTheInTheProcessoPage(String buttonName) throws Throwable {
        this.novoProcessoPage.clickSave(buttonName);
    }

    @Then("^the user should see the \"([^\"]*)\" message in the Mostrar Processo page$")
    public void theUserShouldSeeTheMessageInTheMostrarProcessoPage(String message) throws Throwable {
        Assert.assertEquals(message, this.mostrarProcessoPage.checkNotice());
        String aux = driver.getCurrentURL();
        aux = aux.substring(aux.indexOf("/processos/") + 11); // pega o Id do processo adicionado
        Processo.setLatsProcessoId(aux);
    }

    @And("^the user selects the option \"([^\"]*)\" int the Arbitramento field$")
    public void theUserSelectsTheOptionIntTheArbitramentoField(String value) throws Throwable {
        this.novoProcessoPage.selectArbitramentoOption(value);
    }

    @And("^the user selects the option \"([^\"]*)\" int the \"([^\"]*)\" field$")
    public void theUserSelectsTheOptionIntTheField(String value, String field) throws Throwable {
        this.novoProcessoPage.selectOptionInField(value, field);
    }

    @When("^the user clicks in the button \"([^\"]*)\" of the processo$")
    public void theUserClicksInTheButtonOfTheProcesso(String buttonprefix) throws Throwable {
        String buttonId = buttonprefix + "_" + Processo.getLastProcessoId();
        this.processosPage.clickButton(buttonId);
    }

    @Then("^the user should see the value \"([^\"]*)\" message in the \"([^\"]*)\" field$")
    public void theUserShouldSeeTheValueMessageInTheField(String value, String field) throws Throwable {
        TimeUnit.SECONDS.sleep(2); // para dar tempo da pagina carregar
//        String pageSource = driver.getPageSource();
//        pageSource = pageSource.substring(pageSource.indexOf("<strong>" + field + ":</strong>") + 18 + field.length());
//        pageSource = pageSource.substring(0, pageSource.indexOf("</p>"));
//        pageSource = pageSource.substring(pageSource.indexOf(value));
//        pageSource = pageSource.substring(0,pageSource.indexOf("\n"));
//        Assert.assertEquals(pageSource, value);
        Assert.assertEquals(value,mostrarProcessoPage.checkFieldValue(field));
    }

    @When("^the user clicks in the OK option of the confirmation window$")
    public void theUserClicksInTheOKOptionOfTheConfirmationWindow() throws Throwable {
        TimeUnit.SECONDS.sleep(2); // para dar tempo da tela carregar
        driver.ChooseOkOnNextConfirmation();
        TimeUnit.SECONDS.sleep(2); // para dar tempo da tela carregar
        driver.ChooseOkOnNextConfirmation();
    }

    @Then("^the user should not see the value processo in the processos page$")
    public void theUserShouldNotSeeTheValueProcessoInTheProcessosPage() throws Throwable {
        TimeUnit.SECONDS.sleep(2); // para dar tempo da tela carregar
        //Todos os botões com o Id do registro devem ter sumido
        Assert.assertFalse(driver.getTextAllPage("btn-delete_" + Processo.getLastProcessoId()));
        Assert.assertFalse(driver.getTextAllPage("btn-edit_" + Processo.getLastProcessoId()));
        Assert.assertFalse(driver.getTextAllPage("btn-show_" + Processo.getLastProcessoId()));
    }
}
