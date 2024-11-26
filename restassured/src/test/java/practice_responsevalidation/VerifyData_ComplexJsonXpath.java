package practice_responsevalidation;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class VerifyData_ComplexJsonXpath {
	@Test
	public void sampleTest1() {
		Response res=given().get("http://49.249.28.218:8091/projects-paginated");
				 //res.then().log().all();
				 
				 ArrayList<String> lst=JsonPath.read(res.asString(), ".content[*].projectName");
				 for (String data:lst) {
					 System.out.println(data);
				 }
				 ArrayList<String> lst1=JsonPath.read(res.asString(), ".content[*].[?(@.projectName=='Apple_312')].projectId");
				 String actprojectid=lst1.get(0);

				 Assert.assertEquals(actprojectid, "NH_PROJ_932");
	}
}
