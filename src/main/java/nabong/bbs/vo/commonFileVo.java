package nabong.bbs.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class commonFileVo {
	
	private MultipartFile mpfile;
	
	private String id;
	private String fileName;
	private Date date;
	
	public MultipartFile getMpfile() {
		return mpfile;
	}
	public void setMpfile(MultipartFile mpfile) {
		this.mpfile = mpfile;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
