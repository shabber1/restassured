package pac;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class sampletest {
@Test
public void samplegetreqtest() {
	Response res = RestAssured.get("https://reqres.in/api/users?page=2");
	System.out.println(res.prettyPrint());
}
}
