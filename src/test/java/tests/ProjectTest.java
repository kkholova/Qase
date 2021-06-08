package tests;

import models.Project;
import models.ProjectFactory;
import org.testng.annotations.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.$;

public class ProjectTest extends BaseTest {

    @Test
    public void createProject() {
        loginPage.openLoginPage();
        loginPage.login(user, password);
        projectPage.createNew();
        Project project = ProjectFactory.get();
        projectPage.createNewProject(project);
        projectPage.submit();
        projectPage.projectIsCreated(project.getProjectName());
    }
}
