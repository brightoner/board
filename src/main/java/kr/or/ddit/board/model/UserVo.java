package kr.or.ddit.board.model;

import java.util.Date;

public class UserVo {
	
	private String name;
	private String userid;
	private String alias;
	private String pass;
	private String addr1; 
	private String addr2; 
	private String zipcd; 
	private Date birth;
	private String path;
	private String filename;
	
	public UserVo(String name, String userId, String alias, String pass,
			String addr1, String addr2, String zipcd, Date birth /*, String path,
			String filename*/) {
		super();
		this.name = name;
		this.userid = userid;
		this.alias = alias;
		this.pass = pass;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.zipcd = zipcd;
		this.birth = birth;
//		this.path = path;
//		this.filename = filename;
	}

	@Override
	public String toString() {
		return "UserVo [name=" + name + ", userId=" + userid + ", alias="
				+ alias + ", pass=" + pass + ", addr1=" + addr1 + ", addr2="
				+ addr2 + ", zipcd=" + zipcd + ", birth=" + birth + ", path="
				+ path + ", filename=" + filename + "]";
	}
	
	public UserVo(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getZipcd() {
		return zipcd;
	}

	public void setZipcd(String zipcd) {
		this.zipcd = zipcd;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
	
	
	
	
	

}
