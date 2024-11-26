package authentication;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class DigestiveAuthTest {
@Test
public void sampleTesy() {
	given().log().all().auth().digest("rmgyantra", "rmgy@9999")
	.when().get("http://49.249.29.5:8091/login")
	.then().log().all();
}
}
