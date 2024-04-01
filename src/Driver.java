import java.io.IOException;

import common_method_package.Data_extractor;
import test_case_pkg.delete_tc;
import test_case_pkg.get_tc;
import test_case_pkg.patch_tc;
import test_case_pkg.post_tc;
import test_case_pkg.put_tc;

public class Driver {

	public static void main(String[] args) throws IOException {
		 //TODO Auto-generated method stub
		
	        // post_tc.postExecutor();
		
			  patch_tc.patchExecutor();
			//put_tc.putExecutor();
			//get_tc.getExecutor();
			//delete_tc.deleteExecuter();
	

  	
	
   //Data_extractor.getData("TestData", "patch_tc_data","value_tc2");	
	
	}

}
