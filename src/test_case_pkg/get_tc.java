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

public class get_tc {

	public static void getExecutor() throws IOException {

		for (int i = 0; i < 5; i++) {
			Response complete_response = get_tc.statusCodeExtractor();
			int responseStatusCode = complete_response.statusCode();
			String responseBody = complete_response.getBody().asString();

			if (responseStatusCode == 200) {
				get_tc.RequestResponseValidator(responseBody);
				Evidencefilecreator.evidenceCreator("Getrequest" + LocalDate.now() + ".txt", null, responseBody);
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

	public static Response statusCodeExtractor() {
		RestAssured.baseURI = base_url.base_url();
		Response response = ResponseExtractor.getResponse();
		return response;
	}

	public static void RequestResponseValidator(String responseBody) {
		// step3-create the object of the json path/parse the response body
		JsonPath jsp = new JsonPath(responseBody);
		int count = jsp.getInt("data.size()");
		System.out.println("Response Body");
		// array to store the expected response of id
		String[] expArrayid = new String[count];
		for (int i = 0; i < expArrayid.length; i++) {
			expArrayid[i] = jsp.getString("data[" + i + "].id");
			System.out.println("expected id = " + expArrayid[i]);
		}

		// array to store the expected response of first name
		String[] expArrayfname = new String[count];
		for (int i = 0; i < expArrayfname.length; i++) {
			expArrayfname[i] = jsp.getString("data[" + i + "].first_name");
			System.out.println("expected first_name = " + expArrayfname[i]);
		}
		// array to store the expected response of last name
		String[] expArraylname = new String[count];
		for (int i = 0; i < expArraylname.length; i++) {
			expArraylname[i] = jsp.getString("data[" + i + "].last_name");
			System.out.println("expected last_name = " + expArraylname[i]);
		}
		// array to store the expected response of email
		String[] expArrayemail = new String[count];
		for (int i = 0; i < expArrayemail.length; i++) {
			expArrayemail[i] = jsp.getString("data[" + i + "].email");
			System.out.println("expected email = " + expArrayemail[i]);
		}
		// array to store the expected response of avatar
		String[] expArrayavatar = new String[count];
		for (int i = 0; i < expArrayavatar.length; i++) {
			expArrayavatar[i] = jsp.getString("data[" + i + "].avatar");
			System.out.println("expected avatar = " + expArrayavatar[i]);
		}

		// for loop to extract response and validate with expected result
		for (int i = 0; i < count; i++) {
			String res_id = jsp.getString("data[" + i + "].id");
			System.out.println("Response ID = " + res_id);
			Assert.assertEquals(res_id, expArrayid[i]);

			String res_email = jsp.getString("data[" + i + "].email");
			System.out.println("Response Email = " + res_email);
			Assert.assertEquals(res_email, expArrayemail[i]);

			String res_first_name = jsp.getString("data[" + i + "].first_name");
			System.out.println("Response First Name = " + res_first_name);
			Assert.assertEquals(res_first_name, expArrayfname[i]);

			String res_last_name = jsp.getString("data[" + i + "].last_name");
			System.out.println("Response Last Name = " + res_last_name);
			Assert.assertEquals(res_last_name, expArraylname[i]);

			String res_avatar = jsp.getString("data[" + i + "].avatar");
			System.out.println("Response Avatar = " + res_avatar);
			Assert.assertEquals(res_avatar, expArrayavatar[i]);

		}
	}
}
