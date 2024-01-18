package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


//Created to Perform CRUD operations
public class UserEndPoints2 {
	
	//method used to get urls from property file
	static ResourceBundle getURI(){
		ResourceBundle routes = ResourceBundle.getBundle("routes");//Load Properties
		return routes;
	}
	
	public static Response createUser(User payload) {
		String post_url = getURI().getString("post_url");
	Response response=given()
			
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(payload)
			.when()
					.post(post_url);
		
			return response;
		
	}
	
	public static Response readUser(String userName) {
		String get_url = getURI().getString("get_url");

		Response response=given()
							.pathParam("username", userName)
				
			.when()
					.get(get_url);
		
			return response;
			
		}
	
	public static Response updateUser(String userName,User payload) {
		String update_url = getURI().getString("update_url");

		Response response=given()
					.pathParam("username", userName)
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(payload)
			.when()
					.put(update_url);
		
			return response;
			
		}
	
	public static Response deleteUser(String userName) {
		String delete_url = getURI().getString("delete_url");

		Response response=given()
							.pathParam("username", userName)
				
			.when()
					.delete(delete_url);
		
			return response;
			
		}
	
}
