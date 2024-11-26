package practice_responsevalidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
public class VerifyResponseBody_Via_JsonPath {
	@Test
	public void sampleTest1() {
		Response res=given().get("http://49.249.28.218:8091/projects-paginated");
				 res.then().log().all();
				 
				 res.then().assertThat().body("numberOfElements",Matchers.greaterThanOrEqualTo(20));
				 res.then().assertThat().body("pageable.sort.unsorted",Matchers.equalTo(true));
				 res.then().assertThat().body("content[0].projectId",Matchers.equalTo("NH_PROJ_932"));

		ArrayList<String> lst = res.jsonPath().get("content.projectId");
		System.out.println(lst);
//		int data = res.jsonPath().get("numberOfElements");
//		System.out.println(data);
//		
//		boolean data1= res.jsonPath().get("pageable.sort.unsorted");
//		System.out.println(data1);
//		
//		String data2 = res.jsonPath().get("content[0].projectId");
//		System.out.println(data2);
	}
}
