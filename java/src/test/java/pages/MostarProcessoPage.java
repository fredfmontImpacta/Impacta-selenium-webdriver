package pages;

import support.DriverQA;

public class MostarProcessoPage {

    DriverQA driver;

    public MostarProcessoPage(DriverQA driver) {
        this.driver = driver;
    }

    public String checkNotice() {
        return driver.getText("notice");
    }

    public String checkFieldValue(String field) {
        return this.driver.getText(field);
    }
}
