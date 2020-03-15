package pages;

import support.DriverQA;

public class MenuPage {

    DriverQA driver;

    public MenuPage(DriverQA driver) {
        this.driver = driver;
    }

    public void abrirPagina() {
        this.driver.openURL("http://agapito-server.herokuapp.com/");
    }

    public void clickProcessosMenuOption() {
        this.driver.click("processos");
    }
}
