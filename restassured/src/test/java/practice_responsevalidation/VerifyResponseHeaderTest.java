package practice_responsevalidation;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class VerifyResponseHeaderTest {
@Test
public void verifyheaderTest() {
	Response res = given().get("http://49.249.28.218:8091/project/NH_PROJ_5994");
		res.then().log().all();
		res.then().assertThat().contentType(ContentType.JSON);
		res.then().assertThat().statusLine("HTTP/1.1 200 ");
		res.then().assertThat().statusCode(200);
		res.then().assertThat().header("Connection", "keep-alive");
}
}
