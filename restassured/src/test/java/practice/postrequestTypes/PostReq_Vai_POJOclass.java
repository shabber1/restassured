package practice.postrequestTypes;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoclass.utility.projectPOJO;

public class PostReq_Vai_POJOclass {
@Test
public void postdatatoserver() {
	
	Random random=new Random();
	int rannum=random.nextInt(3000);
	
	projectPOJO pobj=new projectPOJO("abbq"+rannum,"Created","shabber",0);
	
	given().contentType(ContentType.JSON).body(pobj)
	.when().post("http://49.249.28.218:8091/addProject")
	.then().assertThat().statusCode(201).log().all();
	
}
}
