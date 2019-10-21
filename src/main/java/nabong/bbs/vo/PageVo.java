package nabong.bbs.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class PageVo {
	
	private MultipartFile mpfile;
	
	private String id;
	private String fileName;
	private Date date;
	
	/**
	 * 
	 */
	int boardValue;
	//회원정보
	String userId;
	String userPw;
	String userName;
	String joinTime;
	String userIdQustion;
	String userIdAnswer;
	String userJender;
	//게시글 정보
	int boardNo;
	String boardTitle;
	String boardText;
	String boardUser;
	String boardTime;
	int boardCount;
	String boardDateTime;
	//댓글 정보
	int commentNo;
	String commentUser;
	String commentText;
	String commentTime;
	int recommentNo;
	String recommentUser;
	String recommentText;
	String recommentTime;
	//검색 정보
	String searchNo;
	String searchName;
	
	//파일정보
	String filePath;
	String fileChangeName;
	
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(String joinTime) {
		this.joinTime = joinTime;
	}

	public String getUserIdQustion() {
		return userIdQustion;
	}

	public void setUserIdQustion(String userIdQustion) {
		this.userIdQustion = userIdQustion;
	}

	public String getUserIdAnswer() {
		return userIdAnswer;
	}

	public void setUserIdAnswer(String userIdAnswer) {
		this.userIdAnswer = userIdAnswer;
	}

	public String getUserJender() {
		return userJender;
	}

	public void setUserJender(String userJender) {
		this.userJender = userJender;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardText() {
		return boardText;
	}

	public void setBoardText(String boardText) {
		this.boardText = boardText;
	}

	public String getBoardUser() {
		return boardUser;
	}

	public void setBoardUser(String boardUser) {
		this.boardUser = boardUser;
	}

	public String getBoardTime() {
		return boardTime;
	}

	public void setBoardTime(String boardTime) {
		this.boardTime = boardTime;
	}

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	public String getBoardDateTime() {
		return boardDateTime;
	}

	public void setBoardDateTime(String boardDateTime) {
		this.boardDateTime = boardDateTime;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public String getCommentUser() {
		return commentUser;
	}

	public void setCommentUser(String commentUser) {
		this.commentUser = commentUser;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public String getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

	public int getRecommentNo() {
		return recommentNo;
	}

	public void setRecommentNo(int recommentNo) {
		this.recommentNo = recommentNo;
	}

	public String getRecommentUser() {
		return recommentUser;
	}

	public void setRecommentUser(String recommentUser) {
		this.recommentUser = recommentUser;
	}

	public String getRecommentText() {
		return recommentText;
	}

	public void setRecommentText(String recommentText) {
		this.recommentText = recommentText;
	}

	public String getRecommentTime() {
		return recommentTime;
	}

	public void setRecommentTime(String recommentTime) {
		this.recommentTime = recommentTime;
	}
	public int getBoardValue() {
		return boardValue;
	}
	public void setBoardValue(int boardValue) {
		this.boardValue = boardValue;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileChangeName() {
		return fileChangeName;
	}
	public void setFileChangeName(String fileChangeName) {
		this.fileChangeName = fileChangeName;
	}
	public String getSearchNo() {
		return searchNo;
	}
	public void setSearchNo(String searchNo) {
		this.searchNo = searchNo;
	}
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	

}
