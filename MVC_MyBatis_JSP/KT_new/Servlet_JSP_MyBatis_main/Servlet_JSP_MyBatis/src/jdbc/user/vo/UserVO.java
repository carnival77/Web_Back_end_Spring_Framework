package jdbc.user.vo;

//import java.sql.Date;
import java.sql.Timestamp;

//import java.util.*;

/**
 * VO(Value Object)
 * DTO(Data Transfer Object), JavaBeans, Entity, 
 */
public class UserVO {

	/**
	 * 
	 */
	private int id;

	/**
	 * ID
	 */
	private String userid;

	/**
	 * ����� ID
	 */
	private String name;

	public UserVO(String userid, String name, String gender, String city) {
		super();
		this.userid = userid;
		this.name = name;
		this.gender = gender;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public UserVO(int id, String userid, String name, String gender, String city) {
		this(userid, name, gender, city);
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", userid=" + userid + ", name=" + name + ", gender=" + gender + ", city=" + city
				+ ", regdate=" + regdate + "]";
	}

	public UserVO(int id, String userid, String name, String gender, String city, Timestamp regdate) {
		this(id, userid, name, gender, city);
		this.regdate = regdate;
	}

	/**
	 * �̸�
	 */
	private String gender;

	/**
	 * ����
	 */
	private String city;

	/**
	 * �ּ�
	 */
	private Timestamp regdate;

	/**
	 * ��������
	 */
	/**
	 * Default constructor
	 */
	public UserVO() {
	}

}