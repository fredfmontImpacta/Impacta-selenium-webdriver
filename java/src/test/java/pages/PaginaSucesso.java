package pages;

import support.DriverQA;

public class PaginaSucesso {

    private DriverQA driver;

    public PaginaSucesso(DriverQA driver) {
        this.driver = driver;
    }

    public String buscarMensagem() {
        return driver.getText("result");
    }
}
