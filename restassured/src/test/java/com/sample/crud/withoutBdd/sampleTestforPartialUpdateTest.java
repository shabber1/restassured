package com.sample.crud.withoutBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class sampleTestforPartialUpdateTest {
@Test
public void patchdatatoserverTest() {
	JSONObject jsonObj=new JSONObject();

	jsonObj.put("projectName", "sfgd3");
	
	RequestSpecification req = RestAssured.given();
	req.contentType(ContentType.JSON);
	req.body(jsonObj.toJSONString());
	
	Response res=req.patch("http://49.249.28.218:8091/project/NH_PROJ_5983");
	res.then().log().all();
	res.then().assertThat().statusCode(200);
}
}
