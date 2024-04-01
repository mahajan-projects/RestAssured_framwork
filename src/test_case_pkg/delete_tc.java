package test_case_pkg;

import java.io.IOException;
import common_method_package.ResponseExtractor;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import req_repo_pkg.base_url;

public class delete_tc {
	public static void deleteExecuter() throws IOException {

		for (int i = 0; i < 5; i++) {
			Response complete_response = delete_tc.statusCodeExtractor();
			int responseStatusCode = complete_response.statusCode();

			if (responseStatusCode == 204) {
				System.out.println("Records deleted Successfully with Status code : " + responseStatusCode);
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
		Response response = ResponseExtractor.deleteResponse();
		return response;
	}

}