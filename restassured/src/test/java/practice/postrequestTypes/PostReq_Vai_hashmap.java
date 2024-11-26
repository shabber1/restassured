package practice.postrequestTypes;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

import io.restassured.http.ContentType;

public class PostReq_Vai_hashmap {
@Test
public void postdatatoserver() {
	HashMap<String, Object> map=new HashMap();
	
	map.put("createdBy", "shabber");
	map.put("status", "Created");
	map.put("teamSize", 0);
	map.put("projectName", "tekp2");
	
	given().contentType(ContentType.JSON).body(map)
	.when().post("http://49.249.28.218:8091/addProject")
	.then().assertThat().statusCode(201).log().all();
	
}
}
