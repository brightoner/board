package kr.or.ddit.board.model;

public class AttachVo {

	private String attach_id;
	private int post_id;
	private String path;
	private String filename;
	
	public AttachVo(String attach_id, int post_id, String path, String filename) {
		super();
		this.attach_id = attach_id;
		this.post_id = post_id;
		this.path = path;
		this.filename = filename;
	}

	@Override
	public String toString() {
		return "AttachVo [attach_id=" + attach_id + ", post_id=" + post_id
				+ ", path=" + path + ", filename=" + filename + "]";
	}
	
	public AttachVo(){
		
	}
	
	

	public AttachVo(int post_id, String path, String filename) {
		super();
		this.post_id = post_id;
		this.path = path;
		this.filename = filename;
	}

	public String getAttach_id() {
		return attach_id;
	}

	public void setAttach_id(String attach_id) {
		this.attach_id = attach_id;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
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
