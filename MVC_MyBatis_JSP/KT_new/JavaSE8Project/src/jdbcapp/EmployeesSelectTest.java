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

		// ���� �޾Ƽ� �ش� ���ڰ� ���Ե� sql�� ����
		Scanner sc = new Scanner(System.in);
//		String s = scanner.next();
		char c = sc.next().charAt(0);

		//

		// 2. DB���� ������ ����ϴ� Connection ��ü�� ����
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "hr";
		String password = "hr";
		String sql = "select employee_id,  first_name , email, salary , hire_date from employees where first_name like '"+c+"%'";

		Connection con = null;
		Statement stmt = null;

		// Connection con = new T4CConnection();
		// DriverManager�� getConnection() ���ҵ尡 T4CConnection ��ü�� �����ϹǷ� Factory Method ��.

		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println(con.getClass().getName());

			// 3. SQL ������ DB���� �������ִ� Statement ����
			stmt = con.createStatement();
			System.out.println(stmt.getClass().getName());

			// 4. SQL���� ������ ������� ó��
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
