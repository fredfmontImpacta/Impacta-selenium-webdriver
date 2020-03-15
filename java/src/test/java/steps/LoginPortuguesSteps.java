package steps;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import pages.Acesso;
import pages.PaginaErro;
import pages.PaginaSucesso;
import support.BaseSteps;

public class LoginPortuguesSteps extends BaseSteps {

    Acesso acesso = new Acesso(driver);
    PaginaSucesso paginaSucesso = new PaginaSucesso(driver);
    PaginaErro paginaErro = new PaginaErro(driver);

    @Dado("^que o usuario esta na pagina de login$")
    public void queOUsuarioEstaNaPaginaDeLogin() {
        acesso.abrirPagina();
    }

    @E("^que o usuario informa o valor \"([^\"]*)\" no campo \"([^\"]*)\"$")
    public void queOUsuarioInformaOValorNoCampo(String valorCampo, String nomeCampo) throws Throwable {
        acesso.preencherCampo(nomeCampo, valorCampo);
    }

    @Quando("^o usuario clicar no botao de login$")
    public void oUsuarioClicarNoBotaoDeLogin() {
        acesso.clicarBotaoLogin();
    }

    @Entao("^o usuario devera logar e ver a mensagem de \"([^\"]*)\"$")
    public void oUsuarioDeveraVerAMensagemDe(String mensagem) throws Throwable {
        Assert.assertEquals(mensagem, paginaSucesso.buscarMensagem());
    }

    @Entao("^o usuario nao devera logar e ver a mensagem de \"([^\"]*)\"$")
    public void oUsuarioNaoDeveraLogarEVerAMensagemDe(String mensagem) throws Throwable {
        Assert.assertEquals(mensagem, paginaErro.buscarMensagem());
    }
}
