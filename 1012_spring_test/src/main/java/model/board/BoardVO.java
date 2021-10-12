package model.board;

import java.sql.Date;

public class BoardVO {
	// id int primary key,
	// title varchar(30),
	// writer varchar(15),
	// content varchar(100),
	// wdate date default sysdate

	private int id;
	private String title;
	private String writer;
	private String content;
	private Date wdate;
	private String search;
	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}

	@Override
	public String toString() {
		return "BoardVO [id=" + id + ", title=" + title + ", writer=" + writer + ", content=" + content + ", wdate="
				+ wdate + ", search=" + search + "]";
	}


}
