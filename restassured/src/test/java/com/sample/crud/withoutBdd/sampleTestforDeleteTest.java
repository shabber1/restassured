package com.sample.crud.withoutBdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class sampleTestforDeleteTest {
@Test
public void deletedatafromserverTest() {
	Response res = RestAssured.delete("http://49.249.28.218:8091/project/NH_PROJ_5983");
	res.then().assertThat().statusCode(204);
	res.then().log().all();
}
}
