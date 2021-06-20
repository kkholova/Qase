package adapters;

import static io.restassured.RestAssured.given;

public class SuitesAdapter extends BaseAdapter {

    public String create(String body, int status, String code) {
        return post(body, status, "https://api.qase.io/v1/suite/" + code);


    }
}
