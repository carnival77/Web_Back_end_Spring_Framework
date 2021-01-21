package jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;

public class EmployeesSelectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1. Driver Class Loading
		try {
			Class driver = Class.forName("oracle.jdbc.OracleDriver");
			System.out.println(driver.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 문자 받아서 해당 문자가 삽입된 sql문 실행
		Scanner sc = new Scanner(System.in);
//		String s = scanner.next();
		char c = sc.next().charAt(0);

		//

		// 2. DB와의 연결을 담당하는 Connection 객체를 생성
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "hr";
		String password = "hr";
		String sql = "select employee_id,  first_name , email, salary , hire_date from employees where first_name like '"+c+"%'";

		Connection con = null;
		Statement stmt = null;

		// Connection con = new T4CConnection();
		// DriverManager의 getConnection() 에소드가 T4CConnection 객체를 생성하므로 Factory Method 다.

		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println(con.getClass().getName());

			// 3. SQL 쿼리를 DB에게 전송해주는 Statement 생성
			stmt = con.createStatement();
			System.out.println(stmt.getClass().getName());

			// 4. SQL문을 실행한 결과값을 처리
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(rs.getClass().getName());

			while (rs.next()) {
				int emp_id = rs.getInt("employee_id");
				String name = rs.getString("first_name");
				Date hire_date = rs.getDate("hire_date");
				float salary = rs.getFloat("salary");
				System.out.println(emp_id + "\t" + name + "\t" + hire_date + "\t" + salary);
			}
			//

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {

				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
