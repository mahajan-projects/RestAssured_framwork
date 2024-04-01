
package common_method_package;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileDataWritter {

	public static void dataWriter(String file_name, String requestBody, String responseBody) throws IOException {
		File newfile = new File("C:\\Users\\Mayuri Mahajan\\Desktop\\Mayuri_Evidence\\Evidence\\" + file_name);
		System.out.println("New blank file created with name" + newfile.getName());
		FileWriter datawriter = new FileWriter("C:\\Users\\Mayuri Mahajan\\Desktop\\Mayuri_Evidence\\Evidence\\" + file_name);
		datawriter.write("RequestBody : " + "\n" + requestBody + "\n");
		datawriter.write("ResponseBody : " + "\n" + responseBody + "\n");
		datawriter.close();
		System.out.println("request and respone body is written into txt file named :" + newfile.getName() + "\n");
	}
}
