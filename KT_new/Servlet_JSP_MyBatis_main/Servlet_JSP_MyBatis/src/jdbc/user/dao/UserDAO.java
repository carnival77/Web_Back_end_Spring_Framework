package jdbc.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;

import jdbc.user.vo.UserVO;

/**
 * DAO(Data Access Object) : jdbc, mybatis를 사용한 객체
 */
public class UserDAO {
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "scott";
	String password = "tiger";

	/**
	 * Default constructor
	 */
	public UserDAO() {
		try {
			Class driver = Class.forName("oracle.jdbc.OracleDriver");
			System.out.println(driver.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public void close(Statement stmt, Connection con) throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
		if (con != null) {
			con.close();
		}
	}

	/**
	 * @return
	 */
	public List<UserVO> getUsers() {
		// TODO implement here
		return null;
	}

	/**
	 * @param userid
	 * @return
	 */
	public UserVO getUser(String userid) {
		// TODO implement here
		String sql = "select * from users where userid = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		UserVO userVO = null;

		try {
			con = getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, userid);
			rs = stmt.executeQuery();
			if (rs.next()) {
				userVO = new UserVO(rs.getInt("id"), rs.getString("userid"), rs.getString("name"),
						rs.getString("gender"), rs.getString("city"), rs.getTimestamp("regdate"));
			}

			close(stmt, con);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return userVO;
	}

	/**
	 * @param userVO
	 * @return
	 */
	public int insertUser(UserVO userVO) {
		String sql = "INSERT into users values(user_seq.NEXTVAL, ?,?, ?,?,sysdate)";
		Connection con = null;
		PreparedStatement stmt = null;
		int insertCnt = 0;

		try {
			con = getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, userVO.getUserid());
			stmt.setString(1, userVO.getName());
			stmt.setString(1, userVO.getGender());
			stmt.setString(1, userVO.getCity());
			insertCnt = stmt.executeUpdate();

		} catch (SQLException e) {

		} finally {
			try {
				close(stmt, con);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}

		return insertCnt;

		// TODO implement here
	}

	/**
	 * @param userVO
	 */
	public void updateUser(UserVO userVO) {
		String sql = "update users set city = ? where name = ?";
//		String sql = "update into users values(user_seq.NEXTVAL, ?,?, ?,?,sysdate)";
		Connection con = null;
		PreparedStatement stmt = null;
//		int insertCnt = 0;

		try {
			con = getConnection();
			stmt = con.prepareStatement(sql);
			
//			stmt.setString(1, "Payrolls");
//			stmt.setInt(2, 205);
//			stmt.setNull(2, Types.INTEGER);
//			stmt.setInt(3, 270);
			
			stmt.setString(1, "여의도");
			stmt.setString(2, userVO.getName());
//			insertCnt = stmt.executeUpdate();
			
			con.commit();

		} catch (SQLException e) {

		} finally {
			try {
				close(stmt, con);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}

	/**
	 * @param id
	 */
	public void deleteUser(int id) {
		// TODO implement here
	}

}