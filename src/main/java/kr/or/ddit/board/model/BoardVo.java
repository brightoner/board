package kr.or.ddit.board.model;

import java.util.Date;

public class BoardVo {
	
	private int board_id;
	private String userid;
	private String board_name;
	private String use_yn;
	private Date reg_dt;

	
	public BoardVo(int board_id, Date reg_dt) {
		super();
		this.board_id = board_id;
		this.reg_dt = reg_dt;
	}


	public BoardVo(String userid, String board_name, String use_yn) {
		super();
		this.userid = userid;
		this.board_name = board_name;
		this.use_yn = use_yn;
	}


	public BoardVo(){
		
	}

	
	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getBoard_name() {
		return board_name;
	}

	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

	public Date getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	
	
	@Override
	public String toString() {
		return "BoardVo [board_id=" + board_id + ", userid=" + userid
				+ ", board_name=" + board_name + ", use_yn=" + use_yn
				+ ", reg_dt=" + reg_dt + "]";
	}

	
	

}
