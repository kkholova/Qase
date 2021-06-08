package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    public LoginPage openLoginPage() {
        open("/login");
        return this;
    }

    public void login(String user, String password) {
        $("#inputEmail").setValue(user);
        $("#inputPassword").sendKeys(password);
        $("#btnLogin").click();
    }

}
