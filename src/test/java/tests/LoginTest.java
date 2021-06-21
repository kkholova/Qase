package tests;

import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest {

    @Test
    public void login() {
        //https://app.qase.io/login
        loginPage.openLoginPage();
        Assert.assertTrue(loginPage.isPageOpened(),"Login page was not opened");
        loginPage.login(user, password);
        $("#user-menu").shouldBe(Condition.visible);

    }
}
