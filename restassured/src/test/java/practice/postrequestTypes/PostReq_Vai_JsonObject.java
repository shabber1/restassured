package practice.postrequestTypes;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class PostReq_Vai_JsonObject {
@Test
public void postdatatoserver() {
	JSONObject jobj=new JSONObject();
	
	jobj.put("createdBy", "shabber");
	jobj.put("status", "Created");
	jobj.put("teamSize", 0);
	jobj.put("projectName", "tekp1");
	
	given().contentType(ContentType.JSON).body(jobj.toJSONString())
	.when().post("http://49.249.28.218:8091/addProject")
	.then().assertThat().statusCode(201).log().all();
	
}
}
