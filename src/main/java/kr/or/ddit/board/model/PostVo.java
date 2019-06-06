package kr.or.ddit.board.model;

import java.util.Date;

public class PostVo {

	private int post_id;
	private String userid;
	private String title;
	private String content;
	private Date post_date;
	private int parent_id;
	private int board_id;
	
	public PostVo(int post_id, String userid, String title, String content,
			Date post_date, int parent_id, int board_id) {
		super();
		this.post_id = post_id;
		this.userid = userid;
		this.title = title;
		this.content = content;
		this.post_date = post_date;
		this.parent_id = parent_id;
		this.board_id = board_id;
	}

	@Override
	public String toString() {
		return "PostVo [post_id=" + post_id + ", userid=" + userid + ", title="
				+ title + ", content=" + content + ", post_date=" + post_date
				+ ", parent_id=" + parent_id + ", board_id=" + board_id + "]";
	}
	
	public PostVo(){
		
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPost_date() {
		return post_date;
	}

	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	
	
	
	

}
