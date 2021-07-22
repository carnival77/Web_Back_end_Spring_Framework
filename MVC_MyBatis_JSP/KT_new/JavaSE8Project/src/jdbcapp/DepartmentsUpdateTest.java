package jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class DepartmentsUpdateTest {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "hr";
		String password = "hr";
		String sql = "update departments set department_name = ?, manager_id = ? where department_id = ?";

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, user, password);

			con.setAutoCommit(false);

			stmt = con.prepareStatement(sql);
			stmt.setString(1, "Payrolls");
//			stmt.setInt(2, 205);
			stmt.setNull(2, Types.INTEGER);
			stmt.setInt(3, 270);

			int row_cnt = stmt.executeUpdate();
			// commit 실행
			con.commit();

			System.out.println("update 된 건수 : " + row_cnt);

		} catch (Exception e) {
			// rollback 실행
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
