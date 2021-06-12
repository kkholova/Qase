package tests;

import models.Project;
import models.ProjectFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.$;

public class ProjectTest extends BaseTest {

    @Test
    public void createProject() {
        loginPage
                .openLoginPage()
                .login(user, password);
        projectPage.createNew();
        Assert.assertTrue(projectPage.isPageOpened(),"new Project page was not opened");
        Project project = ProjectFactory.get();
        projectPage.createNewProject(project);
        projectPage.submit();
        projectPage.projectIsCreated();
        Assert.assertTrue(projectPage.projectIsCreated(),"Project was not created");
        Assert.assertTrue(projectPage.findProjectInTheProjectList(project.getProjectName()),"Project is not in the list of projects");
    }

    @Test
    public void updateProject(){
        loginPage.openLoginPage();
        loginPage.login(user, password);
        projectPage.createNew();
        Project project = ProjectFactory.get();
        projectPage.createNewProject(project);
        projectPage.submit();
        projectPage.openSettings();
        projectPage.updateProject();
        Assert.assertTrue(projectPage.checkProjectNameIsUpdated(project.getProjectName()),"Project is not updated");
    }

    @Test
    public void deleteProject(){
        loginPage.openLoginPage();
        loginPage.login(user, password);
        projectPage.createNew();
        Project project = ProjectFactory.get();
        projectPage.createNewProject(project);
        projectPage.submit();
        projectPage.deleteProjectFromSettings();
        Assert.assertTrue(projectPage.checkProjectWasDeleted(project.getProjectName()),"Project was not deleted");

    }
}
