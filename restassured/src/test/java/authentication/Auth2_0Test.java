package authentication;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class Auth2_0Test {
	@Test
	public void sampleTest() {
		
		
		
		
		
		given().auth().oauth2("")
		.log().all()
		.when().get("http://49.249.28.218:8091/projects")
		.then().log().all();
	}
}
