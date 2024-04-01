package test_case_pkg;

import java.io.IOException;
import java.time.LocalDate;
import org.testng.Assert;
import common_method_package.Evidencefilecreator;
import common_method_package.ResponseExtractor;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import req_repo_pkg.base_url;
import req_repo_pkg.post_req_repo;

public class post_tc{

	public static void postExecutor() throws IOException {

		for (int i = 0; i < 5; i++) {
			Response complete_response = post_tc.statusCodeExtractor();
			int responseStatusCode = complete_response.statusCode();
			String responseBody = complete_response.getBody().asString();
			String requestBody = post_req_repo.post_request_tc1();

			if (responseStatusCode == 201) {
				post_tc.RequestResponseValidator(requestBody, responseBody);
				Evidencefilecreator.evidenceCreator("Postrequest" + LocalDate.now() + ".txt", requestBody,
						responseBody);
				break;
			} else {
				int k = i + 1;
				if (k < 5) {
					System.out.println("incorect status code found :" + responseStatusCode + " in " + i
							+ " iteration, hence retrying for next iteration " + k);
				} else {
					System.out.println("incorect status code found :" + responseStatusCode + " in " + i
							+ " iteration, couldn't retry more");
				}
			}
		}
	}

	public static Response statusCodeExtractor() throws IOException {
		RestAssured.baseURI = base_url.base_url();
		Response response = ResponseExtractor.postResponse(post_req_repo.post_request_tc1());
		return response;
	}

	public static void RequestResponseValidator(String requestBody, String responseBody) {

		JsonPath jsp_req = new JsonPath(requestBody);
		String req_name = jsp_req.getString("name");
		System.out.println("Request Body ");
		System.out.println("Name = " + req_name);
		String req_job = jsp_req.getString("job");
		System.out.println("Job = " + req_job + "\n");
		System.out.println("Response Body");
		JsonPath jsp_res = new JsonPath(responseBody);
		String res_id = jsp_res.getString("id");
		System.out.println(" ID = " + res_id);

		String res_name = jsp_res.getString("name");
		System.out.println("Name = " + res_name);

		String res_job = jsp_res.getString("job");
		System.out.println("Job = " + res_job);

		String res_date = jsp_res.getString("createdAt").substring(0, 10);
		System.out.println("Date = " + res_date);
		String sysdate = new java.sql.Date(System.currentTimeMillis()).toString();// java.sql.Date constructor

		Assert.assertNotNull(res_id);
		Assert.assertEquals(res_name, req_name);
		Assert.assertEquals(res_job, req_job);
		Assert.assertEquals(res_date, sysdate);

	}

}