package jdbc.user.vo;

import java.sql.Date;

public class User_2VO {
	private int id;

	public User_2VO(int id, String userid, String name, String gender, String city, Date regdate) {
		super();
		this.id = id;
		this.userid = userid;
		this.name = name;
		this.gender = gender;
		this.city = city;
		this.regdate = regdate;
	}

	public User_2VO(String userid, String name) {
		super();
//		this(id,userid,name);
//		this.id = id;
		this.userid = userid;
		this.name = name;
	}

	public User_2VO(int id, String userid, String name) {
		super();
		this.id = id;
		this.userid = userid;
		this.name = name;
	}

	public User_2VO() {
		super();
		// TODO Auto-generated constructor stub
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "User_2VO [id=" + id + ", userid=" + userid + ", name=" + name + "]";
	}

	private String userid;
	private String name;
	private String gender;
	private String city;
	private Date regdate;

}
