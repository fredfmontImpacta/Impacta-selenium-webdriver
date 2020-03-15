package pages;

import support.DriverQA;

public class ProcessosPage {

    DriverQA driver;

    public ProcessosPage(DriverQA driver) {
        this.driver = driver;
    }

    public void clickNovoProcessoButton() {
        this.driver.click("#btn-novo","css");
    }

    public void clickButton(String buttonId) {
        this.driver.click(buttonId);
    }
}
