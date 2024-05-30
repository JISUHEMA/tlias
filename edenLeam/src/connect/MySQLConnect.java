package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnect {

	public static void main(String[] args) throws SQLException {
		

	
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/eden?useSSL=false&serverTimezone=UTC","root", "1234");
		
		
		Statement statement = connection.createStatement();
		
		//String s="select * from employees";
		//String s="update employees set department='营业部' where department='情報技術部'";
		//String s="UPDATE employees SET id_card_number = LPAD(SUBSTRING(id_card_number, -10), 12, '0'); ";
		String s="SELECT  \n"
				+ "  employee_name,\n"
				+ "  (CASE WHEN age <= 30 THEN '年轻人' END) AS '年龄'\n"
				+ "FROM \n"
				+ "  employees;";
		

		
		
		//ResultSet i =statement.executeQuery(s);
		
		//System.out.print(i);
		
		ResultSet resultSet = statement.executeQuery(s);
		while (resultSet.next()) {
			String name=resultSet.getString("employee_name");
			//String department =resultSet.getString("department");
			String age =resultSet.getString("年龄");
			
		
		
		/*employee_id INT PRIMARY KEY,
			employee_name VARCHAR(20),
			gender VARCHAR(10),
			age INT,
			department VARCHAR(20),
			salary INT,
			address VARCHAR(50),
			id_card_number VARCHAR(20)
		
		while(resultSet.next()) {
			System.out.println(resultSet.getInt("employee_id")+resultSet.getString("employee_name"));
		}
		*/
		/*while (resultSet.next()) {
			int id = resultSet.getInt("employee_id");
			String name = resultSet.getString("employee_name");
			String gender = resultSet.getString("gender");
		String age = resultSet.getString("age");
			String department = resultSet.getString("department");
			String address = resultSet.getString("address");
			String idCardNumber = resultSet.getString("id_card_number");
		
			System.out.println(
					id + " " + name + " " + gender + " " + age + " " + department + " " + address + " " + idCardNumber);*/
		System.out.println(name+" " +" "+age);
		}
		connection.close();
	}
}
	