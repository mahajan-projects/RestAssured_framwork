package common_method_package;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;


public class ResponseExtractor {
	public static Response postResponse(String requestbody) {
		Response response = given().header("Content-type", "application/json").body(requestbody).when()
				.post("/api/users").then().extract().response();
		return response;
	}

	public static Response patchResponse(String requestbody) {
		Response response = given().header("Content-type", "application/json").body(requestbody).when()
				.patch("/api/users/2").then().extract().response();
		return response;
	}

	public static Response putResponse(String requestbody) {
		Response response = given().header("Content-type", "application/json").body(requestbody).when()
				.put("/api/users/2").then().extract().response();
		return response;
	}

	public static Response getResponse() {
		Response response = given().header("Content-type", "application/json").when().get("/api/users?page=2").then()
				.extract().response();
		return response;
	}

	public static Response deleteResponse() {
		Response response = given().header("Content-type", "application/json").when().delete("/api/users/2").then()
				.extract().response();
		return response;
	}

}
