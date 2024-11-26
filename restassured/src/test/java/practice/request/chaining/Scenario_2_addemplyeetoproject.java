package practice.request.chaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.utility.employeePojo;
import pojoclass.utility.projectPOJO;

public class Scenario_2_addemplyeetoproject {
	@Test
	public void postdatatoserver() {
		
		Random random=new Random();
		int rannum=random.nextInt(3000);
		
		
		//API--1 creating 
		
		projectPOJO pobj=new projectPOJO("abbc"+rannum,"Created","shabber",0);
		
		Response res= given().contentType(ContentType.JSON).body(pobj)
		.when().post("http://49.249.28.218:8091/addProject");
		res.then().assertThat().body("msg",Matchers.equalTo("Successfully Added"))
		.statusCode(201).log().all();
		
		String projectname = res.jsonPath().get("projectName");
		System.out.println(projectname);
		
		//api-2 add employee to same project
		//String designation, String dob, String email, String empName, int experience,
		//String mobileNo, String project, String role, String username
		
		employeePojo empobj=new employeePojo("Arcitect", "24/04/1997", "sha@gmail.com", "user_"+rannum, 15, "9951488523", projectname, "ROLE_EMPLOYEE", "user_"+rannum);
		
		given().contentType(ContentType.JSON).body(empobj)
		.when().post("http://49.249.28.218:8091/employees")
		.then().assertThat().statusCode(201).log().all();
		
		
		
}
}
