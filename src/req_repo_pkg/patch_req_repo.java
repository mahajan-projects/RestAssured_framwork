package req_repo_pkg;

import java.io.IOException;
import java.util.ArrayList;

import common_method_package.Data_extractor;

public class patch_req_repo {
	public static String patch_request_tc1() throws IOException {
		
		
		
		ArrayList<String>tc_Arraylist=Data_extractor.getData("TestData", "patch_tc_data","value_tc3");
		String name=tc_Arraylist.get(1);
		String job=tc_Arraylist.get(2);
		
		
		String requestBody="{\r\n"
				+ "    \"name\": \""+name+"\",\r\n"
				+ "    \"job\": \""+job+"\"\r\n"
				+ "}";
		return requestBody;
		
	}

}