package notice.vo;

import java.sql.Timestamp;

public class NoticeVO {
	private int no;
	private String title;
	private String author;
	private String content;
	public NoticeVO(String title, String author, String content) {
		super();
		this.title = title;
		this.author = author;
		this.content = content;
	}
	public NoticeVO(int no, String title, String author, int readcnt) {
		super();
		this.no = no;
		this.title = title;
		this.author = author;
		this.readcnt = readcnt;
	}
	public NoticeVO(int no, String title, String author, String content, int readcnt) {
		super();
		this.no = no;
		this.title = title;
		this.author = author;
		this.content = content;
		this.readcnt = readcnt;
	}
	private Timestamp writeday;
	private int readcnt;
	public NoticeVO(int no, String title, String author, String content, Timestamp writeday, int readcnt) {
		super();
		this.no = no;
		this.title = title;
		this.author = author;
		this.content = content;
		this.writeday = writeday;
		this.readcnt = readcnt;
	}
	@Override
	public String toString() {
		return "NoticeVO [no=" + no + ", title=" + title + ", author=" + author + ", content=" + content + ", writeday="
				+ writeday + ", readcnt=" + readcnt + "]";
	}
	public NoticeVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getWriteday() {
		return writeday;
	}
	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
}
