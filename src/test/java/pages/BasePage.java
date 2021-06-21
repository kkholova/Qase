package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public abstract class BasePage {
    public abstract boolean isPageOpened();

    public boolean isExist(SelenideElement locator){
        try{
            $(locator);
            return true;
        }catch(NoSuchElementException exception){
            log.warn("Element is not exist on page");
            log.warn(exception.getLocalizedMessage());
            return false;
        }

    }
}
