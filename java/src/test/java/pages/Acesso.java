package pages;

import support.DriverQA;

public class Acesso {

    DriverQA driver;

    public Acesso(DriverQA driver) {
        this.driver = driver;
    }

    public void abrirPagina() {
        driver.openURL("file:///C:/Users/USUARIO/Documents/Faculdade/AutomacaoDeTestes/selenium-webdriver/html/login.html");
    }

    public void preencherCampo(String campo, String valor) {
        driver.sendKeys(valor, campo);
    }

    public void clicarBotaoLogin() {
        driver.click("btnLogin");
    }
}
