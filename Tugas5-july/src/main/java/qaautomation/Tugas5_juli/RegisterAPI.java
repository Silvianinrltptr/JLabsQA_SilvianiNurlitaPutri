package qaautomation.Tugas5_juli;


import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;


public class RegisterAPI extends BaseAPI{

	@Test
	public void regisAPISuccess() {
		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		String email = faker.name().lastName() + faker.number().digits(8);
		String phoneNumber = faker.phoneNumber().subscriberNumber(8);
		
		String payload = "{\"user\":{\"first_name\":\""+firstName+"\","
				+ "\"last_name\":\"\",\"email\":\""+email+"@gmail.com\","
				+ "\"password\":\"gamezasdax\",\"phone_number\":\"+62-"+phoneNumber+"\","
				+ "\"user_type\":\"User\",\"currency_id\":2}}";
		
		Response responseRegis = given().spec(commonJsonSpec).body(payload).when().post("/users");
		assertEquals(responseRegis.statusCode(), 200);
	}
	
	@Test
	 public void regisAPIFailedSameEmail() {
	 	String message = "";
	 	Faker faker = new Faker();
		String firstName = faker.name().firstName();
		String email = faker.name().lastName() + faker.number().digits(8) + faker.number().digits(8);
		String phoneNumber = faker.phoneNumber().subscriberNumber(8);
		
		String payload = "{\"user\":{\"first_name\":\""+firstName+"\","
				+ "\"last_name\":\"\",\"email\":\"silvi@gmail.com\","
				+ "\"password\":\"gamezasdax\",\"phone_number\":\"+62-"+phoneNumber+"\","
				+ "\"user_type\":\"User\",\"currency_id\":2}}";
		
	 	Response responseRegisFailedEmail = given().spec(commonJsonSpec).body(payload).when().post("/users");
	 	assertEquals(responseRegisFailedEmail.statusCode(), 422);
	 	assertEquals(responseRegisFailedEmail.jsonPath().get("message"), "Sign up failure");
	 	System.out.println(responseRegisFailedEmail);
	 	System.out.println(responseRegisFailedEmail.getBody());
	 	message = responseRegisFailedEmail.jsonPath().get("message");
	 	System.out.println("Message: "+ message );
	 }
	
	 @Test
	 public void regisAPIFailedFirstNameBlank() {
		String message = "";
		Faker faker = new Faker();
		String email = faker.name().lastName() + faker.number().digits(8);
		String phoneNumber = faker.phoneNumber().subscriberNumber(8);
		
		String payload = "{\"user\":{\"first_name\":\"\","
				+ "\"last_name\":\"\",\"email\":\""+email+"@gmail.com\","
				+ "\"password\":\"gamezasdax\",\"phone_number\":\"+62-"+phoneNumber+"\","
				+ "\"user_type\":\"User\",\"currency_id\":2}}";
		
	 	Response responseRegisFailedFirstNameBlank = given().spec(commonJsonSpec).body(payload).when().post("/users");
	 	assertEquals(responseRegisFailedFirstNameBlank.statusCode(), 422);
	 	assertEquals(responseRegisFailedFirstNameBlank.jsonPath().get("message"), "Sign up failure");
	 	assertEquals(responseRegisFailedFirstNameBlank.jsonPath().get("errors").toString(), "{first_name=[can't be blank]}");
	 	
	 	message = responseRegisFailedFirstNameBlank.getBody().jsonPath().get("errors").toString();
	 	System.out.println("Message: "+ message );
	 }
	 
}

