package com.sample.crud.withBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class sampleTestforCompleteUpdateTest {
@Test
public void putdatatoserverTest() {
	JSONObject jsonObj=new JSONObject();
	jsonObj.put("createdBy", "shfjs");
	jsonObj.put("projectName", "sfgd2");
	jsonObj.put("status", "Created");
	jsonObj.put("teamSize", 0);

	given().contentType(ContentType.JSON).body(jsonObj.toJSONString())
	
	.when().put("http://49.249.28.218:8091/project/NH_PROJ_6009")
	.then().assertThat().statusCode(200).log().all();
}
}
