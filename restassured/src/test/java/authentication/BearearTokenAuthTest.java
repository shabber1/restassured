package authentication;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class BearearTokenAuthTest {
@Test
public void sampleTest() {
	given().auth().oauth2("5atCpg5gSYlRCcilmD0bCkWEtknx6LcmWd_O0GxFNpRyPmutH8tOO2zu_P2QQpubAyrkVmDtBMRUWA4LLGZcXorQHT86wCaiMrnU_lvUh0tJ774340T7ZOQ")
	.log().all()
	.when().get("http://49.249.28.218:8091/projects")
	.then().log().all();
}
}
