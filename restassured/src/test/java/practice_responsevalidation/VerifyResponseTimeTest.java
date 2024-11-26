package practice_responsevalidation;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class VerifyResponseTimeTest {
@Test
public void verifyresponseTest() {
	Response res = given().get("http://49.249.28.218:8091/project/NH_PROJ_5994");
	res.then().log().all();
	
	long timetaken = res.time();
	long timetakensec = res.timeIn(TimeUnit.SECONDS);
	
	System.out.println(timetaken);
	System.out.println(timetakensec);
	
	res.then().assertThat().time(Matchers.lessThan(900L));
	res.then().assertThat().time(Matchers.greaterThan(300L));
	res.then().assertThat().time(Matchers.both(Matchers.lessThan(900L)).and(Matchers.greaterThan(300L)));

}
}
