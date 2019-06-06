package kr.or.ddit.board.model;

import java.util.Date;

public class ReplyVo {
	
	private int renum;
	private int bonum;
	private String name;
	private String cont;
	private Date redate;
	
	public ReplyVo(int renum, int bonum, String name, String cont, Date redate) {
		super();
		this.renum = renum;
		this.bonum = bonum;
		this.name = name;
		this.cont = cont;
		this.redate = redate;
	}

	@Override
	public String toString() {
		return "ReplyVo [renum=" + renum + ", bonum=" + bonum + ", name="
				+ name + ", cont=" + cont + ", redate=" + redate + "]";
	}
	
	public ReplyVo(){
		
	}

	public int getRenum() {
		return renum;
	}

	public void setRenum(int renum) {
		this.renum = renum;
	}

	public int getBonum() {
		return bonum;
	}

	public void setBonum(int bonum) {
		this.bonum = bonum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCont() {
		return cont;
	}

	public void setCont(String cont) {
		this.cont = cont;
	}

	public Date getRedate() {
		return redate;
	}

	public void setRedate(Date redate) {
		this.redate = redate;
	}
	
	
	
	
	
	
	
	

}
