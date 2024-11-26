package practice.request.chaining;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.utility.projectPOJO;

public class Scenario_1_Delete_Project {
@Test
public void postdatatoserver() {
	
	Random random=new Random();
	int rannum=random.nextInt(3000);
	
	
	//API--1 creating 
	
	projectPOJO pobj=new projectPOJO("abbq"+rannum,"Created","shabber",0);
	
	Response res= given().contentType(ContentType.JSON).body(pobj)
	.when().post("http://49.249.28.218:8091/addProject");
	res.then().assertThat().body("msg",Matchers.equalTo("Successfully Added"))
	.statusCode(201).log().all();
	
	String projectId = res.jsonPath().get("projectId");
	System.out.println(projectId);
	
	//Api-2 deleting
	given().delete("http://49.249.28.218:8091/project/"+projectId)
	.then().log().all();
	
	
}
}
