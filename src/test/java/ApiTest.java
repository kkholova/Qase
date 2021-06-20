import adapters.ProjectAdapter;
import models.Project;
import models.ProjectFactory;
import models.ResponseProject;
import models.ResponseStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {

//    @Test
//    public void projectTest() {
//        Project project = ProjectFactory.get();
//        ResponseStatus actual = new ProjectAdapter().create(project, 200);
//        Assert.assertEquals(response,
//                "{\n" +
//                        "                        \"status\": false,\n" +
//                        "                \"errorMessage\": \"Data is invalid\",\n" +
//                        "                \"errorFields\": [\n" +
//                        "        {\n" +
//                        "            \"field\": \"title\",\n" +
//                        "                \"error\": \"Title is required\"\n" +
//                        "        },\n" +
//                        "        {\n" +
//                        "            \"field\": \"code\",\n" +
//                        "                \"error\": \"Project code is required\"\n" +
//                        "        }\n" +
//                        "    ]\n" +
//                        "}");
//
//
//    }

    @Test
    public void createNewProjectWithAllFiels() {
        Project project = ProjectFactory.get();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        Assert.assertEquals(actual.isStatus(),true);
        Assert.assertEquals(actual.getResult().getCode(),project.getCode());
    }

    @Test
    public void createNewProjectWithSpecificGroupType() {
        Project project = Project.builder()
                .title(ProjectFactory.get().getTitle())
                .code(ProjectFactory.get().getCode())
                .accessType("Private")
                .memberType("Group")
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        Assert.assertEquals(actual.isStatus(),true);
        Assert.assertEquals(actual.getResult().getCode(),project.getCode());
    }

    @Test
    public void createNewProjectWithNoneMemberType() {
        Project project = Project.builder()
                .title(ProjectFactory.get().getTitle())
                .code(ProjectFactory.get().getCode())
                .accessType("Private")
                .memberType("None")
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        Assert.assertEquals(actual.isStatus(),true);
        Assert.assertEquals(actual.getResult().getCode(),project.getCode());
    }

    @Test
    public void createNewProjectWithPublicAccessType() {
        Project project = Project.builder()
                .title(ProjectFactory.get().getTitle())
                .code(ProjectFactory.get().getCode())
                .accessType("Public")
                .build();
        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        Assert.assertEquals(actual.isStatus(),true);
        Assert.assertEquals(actual.getResult().getCode(),project.getCode());
    }



    @Test
    public void findProject(){
        ResponseProject project = new ProjectAdapter().getProject("HZZIBHTDGO");
        System.out.println(project);

    }
}
