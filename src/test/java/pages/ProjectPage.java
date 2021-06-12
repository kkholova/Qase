package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class ProjectPage extends BasePage {
    public static final SelenideElement TITLE = $("#inputTitle");
    public static final SelenideElement DESCRIPTION = $("#inputDescription");
    public static final SelenideElement SUBMIT = $("[type = submit]");
    public static final SelenideElement NEW_PROJECT_BUTTON = $("#createButton");
    String accessType = "#private-access-type";
    String memberType = "#accessAll";
    String textToUpdate = "updated ";



    public void createNew() {
        NEW_PROJECT_BUTTON.click();
    }

    public String chooseAccessType(String accessType) {
        switch (accessType) {
            case "Private":
                accessType = "#private-access-type";
                break;
            case "Public":
                accessType = "#public-access-type";
                break;
        }
        return accessType;
    }

    public String chooseMemberType(String memberType) {
        switch (memberType) {
            case "All":
                memberType = "#accessAll";
                break;
            case "Group":
                memberType = "#accessGroup";
                break;
            case "None":
                memberType = "#accessNone";
                break;
        }
        return memberType;
    }

    @Step("Create new Project")
    public void createNewProject(Project project) {
        log.info("Creating New project");
        String projectAccessType = project.getAccessType();
        String memberType = project.getMemberType();
        TITLE.sendKeys(project.getProjectName());
        DESCRIPTION.sendKeys(project.getDescription());
        $(chooseAccessType(projectAccessType)).click();
        if (!projectAccessType.equals("Public")) {
            $(chooseMemberType(memberType)).click();
        }

    }

    public void submit() {
        SUBMIT.click();
    }

    @Step("Find project on Projects Page")
    public boolean findProjectInTheProjectList(String projectName) {
        log.info("Looking for project on projects page");
        $(".nav-link-title").shouldHave(Condition.text("Projects")).click();
        $(".form-control").sendKeys(projectName);
        return $(".defect-title").shouldHave(Condition.text(projectName)).isDisplayed();
    }

    @Step("Check that project was created")
    public boolean projectIsCreated() {
        $("#project-avatar-container").shouldBe(Condition.visible);
        return true;
    }

    @Override
    public boolean isPageOpened() {
        return isExist(SUBMIT);
    }

    @Step("Open settings page")
    public void openSettings(){
        $("[title = Settings]").click();
    }

    @Step("Update project")
    public void updateProject(){
        $("#inputTitle").sendKeys(textToUpdate);
        $("#inputDescription").sendKeys(textToUpdate);
        String accessValue = $("[checked]").getAttribute("value");
        if(accessValue.equals("public")){
            $("[value = private]").click();
        }else {
            $("[value = public]").click();
        }
        SUBMIT.click();
    }

    @Step("Check Project name was updated")
    public boolean checkProjectNameIsUpdated(String projectName){
        projectName = textToUpdate + projectName;
        return findProjectInTheProjectList(projectName);
    }

    @Step("Delete project")
    public void deleteProjectFromSettings(){
        openSettings();
        $(".btn-cancel").click();
        SUBMIT.click();
    }

    @Step("Check that project was deleted")
    public boolean checkProjectWasDeleted(String projectName){
        log.info("Looking for project on projects page");
        $(".nav-link-title").shouldHave(Condition.text("Projects")).click();
        $(".form-control").sendKeys(projectName);
        return $(".defect-title").shouldNot(Condition.text(projectName)).isDisplayed();
    }
}

