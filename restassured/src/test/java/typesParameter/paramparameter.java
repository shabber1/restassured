package typesParameter;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class paramparameter {
@Test
public void sampleTest() {
	given()
	.param("teamSize", 1).log().all()
	.when().get("http://49.249.28.218:8091/project")
	.then().log().all();
}
}
