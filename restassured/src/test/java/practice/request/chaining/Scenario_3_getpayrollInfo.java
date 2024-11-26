package practice.request.chaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class Scenario_3_getpayrollInfo {
@Test
public void sampleTest() {
		//api-1 get outh
	//this info will come from developer
	Response res=given()
			.formParam("client_id", "ninza-client")
			.formParam("client_secret", "gPQBf1Yxew50MccMhzos1GefIyiSnXzM")	
			.formParam("grant_type", "client_credentials")
	.when().post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
	res.then().log().all();
	
	String token = res.jsonPath().get("access_token");
	
  given().auth().oauth2(token).get("http://49.249.28.218:8091/payrolls")
  .then().log().all();
}
}
