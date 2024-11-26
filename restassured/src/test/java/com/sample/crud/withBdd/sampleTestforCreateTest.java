package com.sample.crud.withBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class sampleTestforCreateTest {
@Test
public void postdatatoserverTest() {
	JSONObject jsonObj=new JSONObject();
	jsonObj.put("createdBy", "shfjs");
	jsonObj.put("projectName", "sfgd1");
	jsonObj.put("status", "Created");
	jsonObj.put("teamSize", 0);

	given().contentType(ContentType.JSON).body(jsonObj.toJSONString())
	
	.when().post("http://49.249.28.218:8091/addProject")
	.then().assertThat().statusCode(201).log().all();
}
}
