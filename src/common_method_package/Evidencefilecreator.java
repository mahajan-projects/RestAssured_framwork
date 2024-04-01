package common_method_package;

import java.io.File;
import java.io.IOException;

public class Evidencefilecreator {
	public static void evidenceCreator(String file_name, String requestBody, String responseBody) throws IOException {

		File newfile = new File("C:\\Users\\Mayuri Mahajan\\Desktop\\Mayuri_Evidence\\Evidence\\" + file_name);
		if (newfile.createNewFile()) {
			
			FileDataWritter.dataWriter(file_name, requestBody, responseBody);
		} else {
			System.out.println(newfile.getName() + "this file is already exist, hence Deleting and Recreating it");
			newfile.delete();
			FileDataWritter.dataWriter(file_name, requestBody, responseBody);
		}

	}

}


