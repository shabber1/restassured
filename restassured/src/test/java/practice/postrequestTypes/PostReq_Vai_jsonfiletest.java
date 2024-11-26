package practice.postrequestTypes;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.HashMap;

import io.restassured.http.ContentType;

public class PostReq_Vai_jsonfiletest {
@Test
public void postdatatoserver() {
	File fobj=new File("./project.json");
	given().contentType(ContentType.JSON).body(fobj)
	.when().post("http://49.249.28.218:8091/addProject")
	.then().assertThat().statusCode(201).log().all();
	
}
}
