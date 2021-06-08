package pages;

import com.codeborne.selenide.Condition;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {
    String label;

    //    public Input(String label){
//        this.label = label;
//    }
//
    public void createNew() {
        $("#createButton").click();
    }

    public void createNewProject(Project project) {
        $("#inputTitle").sendKeys(project.getProjectName());
        $("#inputDescription").sendKeys(project.getDescription());
        $("#public-access-type").click();
    }

    public void submit() {
        $("[type = submit]").click();
    }

    public boolean projectIsCreated(String projectName) {
        $(".nav-link-title").shouldHave(Condition.text("Projects")).click();
        $(".form-control").sendKeys(projectName);
        return $(".defect-title").shouldHave(Condition.text(projectName)).isDisplayed();

    }
}
