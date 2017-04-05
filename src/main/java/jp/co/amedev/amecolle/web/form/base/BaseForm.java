package jp.co.amedev.amecolle.web.form.base;

import java.util.Date;

public class BaseForm {

	private Long id;

	private String userId;

	private String password;
	
	private String winNum;

	private String loseNum;
	
	private Date latestLoginTime;

	private Date updateTime;
	
	public String getWinNum() {
		return winNum;
	}

	public void setWinNum(String winNum) {
		this.winNum = winNum;
	}

	public String getLoseNum() {
		return loseNum;
	}

	public void setLoseNum(String loseNum) {
		this.loseNum = loseNum;
	}

	public Date getLatestLoginTime() {
		return latestLoginTime;
	}

	public void setLatestLoginTime(Date latestLoginTime) {
		this.latestLoginTime = latestLoginTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
