package pages;

import support.DriverQA;

public class ProcessoPage {

    DriverQA driver;

    public ProcessoPage(DriverQA driver) {
        this.driver = driver;
    }

    public void fillField(String value, String field) {
        this.driver.sendKeys(value, field);
    }

    public void clickSave(String buttonName) {
        this.driver.click("btn-save");
    }

    public void selectArbitramentoOption(String value) {
        if (value.equals("Sim")) this.driver.click("processo_arbitramento_s");
        else if (value.equals("Não")) this.driver.click("processo_arbitramento_n");
    }

    public void selectOptionInField(String value, String field) {
        this.driver.selectByText(value, field);
    }
}
