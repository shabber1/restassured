package typesParameter;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class formParameter {
@Test
public void sampleTest() {
	given()
	.formParam("teamSize", 1).log().all()
	.when().post("http://49.249.28.218:8091/project")
	.then().log().all();
}
}
