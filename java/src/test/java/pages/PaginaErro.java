package pages;

import support.DriverQA;

public class PaginaErro {

    private DriverQA driver;

    public PaginaErro(DriverQA driver) {
        this.driver = driver;
    }

    public String buscarMensagem() {
        return driver.getText("result");
    }
}
