package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage extends BasePage{
    public static final SelenideElement LOGIN_BUTTON = $("#btnLogin");

    @Step("Open login page")
    public LoginPage openLoginPage() {
        open("/login");
        return this;
    }

    @Step("Fiil in login form")
    public void login(String user, String password) {
        $("#inputEmail").setValue(user);
        $("#inputPassword").sendKeys(password);
        $(LOGIN_BUTTON).click();
    }

    @Override
    @Step("Check that login page was opened")
    public boolean isPageOpened() {
        return isExist(LOGIN_BUTTON);
    }


}
