package dataDrivenTesting;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class AddmultipleProjectTest {
@Test(dataProvider = "getData")
public void sampleTest(String pName, String Status) {
	
	String reqBody = "{\r\n"
			+ "  \"createdBy\": \"string\",\r\n"
			+ "  \"projectName\": \""+pName+"\",\r\n"
			+ "  \"status\": \""+Status+"\",\r\n"
			+ "  \"teamSize\": 0\r\n"
			+ "}";
	
	given().contentType(ContentType.JSON).body(reqBody)
	.when().post("http://49.249.28.218:8091/addProject")
	.then().log().all();
}
@DataProvider
public Object[][] getData() throws Throwable {
	ExcelUtility elib=new ExcelUtility();
	int count = elib.getRowcount("project");
	Object[][] objarr=new Object[count][2];
	
	for(int i=0;i<count;i++) {
		objarr[i][0]=elib.getDataFromExcel("project", i+1, 0);
		objarr[i][1]=elib.getDataFromExcel("project", i+1, 1);
	}
	
	return objarr;

}
}
