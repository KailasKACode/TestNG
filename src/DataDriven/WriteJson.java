package DataDriven;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WriteJson {
	public static void main(String[] args) {
		JSONObject emp=new JSONObject();
		emp.put(1, "suresh");		
		emp.put(2, "Pankaj");
		emp.put(3, "Avinash");
		emp.put(4, "Shashank");
		emp.put(5, "Shashi");
		emp.put(6, "Rohit");
	
		JSONObject empobject=new JSONObject();
		empobject.put("Employee", emp);
	
		JSONObject emp1=new JSONObject();
		emp1.put(10, "Shweta");
		emp1.put(9, "Eliza");
		emp1.put(8, "Sharel");
		emp1.put(7, "Soniya");
		emp1.put(6, "Kiran");
		emp1.put(5, "AAliya");
		
		JSONObject emp1object=new JSONObject();
		emp1object.put("Employee1", emp1);
		
		JSONArray employeelist=new JSONArray();
		employeelist.add(empobject);
		employeelist.add(emp1object);
		try {
			FileWriter fis=new FileWriter("C:\\Users\\Kailas\\Desktop\\SlackDoc\\demo.json");
			fis.write(employeelist.toJSONString());
			fis.flush();
		} catch (IOException e) {
			System.out.println("File not found to save: ");
		}
	//	System.out.print("\n "+empobject+"   "+emp1object);

		
	}

}
