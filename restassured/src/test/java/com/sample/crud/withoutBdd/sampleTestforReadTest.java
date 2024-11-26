package com.sample.crud.withoutBdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class sampleTestforReadTest {
@Test
public void getdatafromserverTest() {
	Response res = RestAssured.get("http://49.249.28.218:8091/projects");
	res.then().assertThat().statusCode(200);
	res.then().log().all();
}
}
