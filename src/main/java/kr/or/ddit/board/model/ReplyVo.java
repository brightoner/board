package kr.or.ddit.board.model;

import java.util.Date;

public class ReplyVo {

	private int reply_id;
	private int post_id;
	private String reply_content;
	private Date reply_date;
	private String userid;
	private String reuse_yn;

	public ReplyVo(int post_id, String reply_content,
			String userid) {
		this.post_id = post_id;
		this.reply_content = reply_content;
		this.userid = userid;
	}

	public ReplyVo() {

	}

	public ReplyVo(int post_id, String reply_content, Date reply_date,
			String userid) {
		this.post_id = post_id;
		this.reply_content = reply_content;
		this.reply_date = reply_date;
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "ReplyVo [reply_id=" + reply_id + ", post_id=" + post_id
				+ ", reply_content=" + reply_content + ", reply_date="
				+ reply_date + ", userid=" + userid + ", reuse_yn=" + reuse_yn
				+ "]";
	}

	public int getReply_id() {
		return reply_id;
	}

	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public Date getReply_date() {
		return reply_date;
	}

	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getReuse_yn() {
		return reuse_yn;
	}

	public void setReuse_yn(String reuse_yn) {
		this.reuse_yn = reuse_yn;
	}

}
