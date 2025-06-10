package RestAssuredAPITestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;


public class PetModuleAPIs {

	@BeforeMethod
	public void setup() {
		
		RestAssured.baseURI = "https://petstore.swagger.io";

	}
	
	
	//Test Case1: To Validate that the request is successfully processed or not with Valid URL
	
	@Test
	public void getPetStatus_TC_001()
	{	
		given().log().all()
			.when().log().all()
				.get("/v2/pet/findByStatus")
					.then().log().all()
						.assertThat()
							.statusCode(200);
	}
	
	
	//Test Case2: To Validate the request if the URL is Invalid and Application should throw 401 Error
	
	@Test
	public void getPetStatus_TC_002()
	{	
		given().log().all()
			.when().log().all()
				.get("/v2/pet/findByStatus01")
					.then().log().all()
						.assertThat()
							.statusCode(404);
	}
	
	
	//Test Case3: To Validate the request with Status = Available
	// Implemented with the help of QueryParam
	
	@Test
	public void getPetStatus_TC_003()
	{	
		given().log().all()
			.queryParam("status", "available")
				.when().log().all()
					.get("/v2/pet/findByStatus")
						.then().log().all()
							.assertThat()
								.statusCode(200);
	}
	
	// Test Case4: To Validate the request with Status = pending
	// Implementation with the help of HashMap
	
		@Test
		public void getPetStatus_TC_004()
		{			
			Map<String, String> queryMap = new HashMap<String, String>();
			queryMap.put("status", "pending");
			
			given().log().all()
				.when().log().all()
					.get("/v2/pet/findByStatus")
						.then().log().all()
							.assertThat()
								.statusCode(200);
		}
		
		
	// Test Case5: To Validate the request with Status = sold
	// Implemented with the help of QueryParam
	
		@Test
		public void getPetStatus_TC_005()
		{		
			given().log().all()
				.queryParam("status", "sold")
					.when().log().all()
						.get("/v2/pet/findByStatus")
							.then().log().all()
								.assertThat()
									.statusCode(200);
		}	
		
		
	//Test Case6: To Validate that the application is fetch the Pet Details based on ID
	
		@Test
		public void findPetByID_TC_006()
		{		
			given().log().all()
				.when().log().all()
					.get("/v2/pet/2580") // Used Pet ID --> 2580
						.then().log().all()
							.assertThat()
								.statusCode(200);
		}	
	

}
