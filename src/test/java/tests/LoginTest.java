package tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest {

    @Test
    public void login() {
        //https://app.qase.io/login
        loginPage.openLoginPage();
        loginPage.login(user, password);
        $("#user-menu").shouldBe(Condition.visible);

    }
}
