package qaautomation.Tugas5_juli;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseAPI {
	
	RequestSpecification commonJsonSpec = new RequestSpecBuilder().setBaseUri("https://api-production-builder.engineer.ai")
			.setContentType(ContentType.JSON).build().log().all();
}
