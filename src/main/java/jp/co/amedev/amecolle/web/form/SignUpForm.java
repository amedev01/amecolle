package jp.co.amedev.amecolle.web.form;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author m-zama
 *
 */
public class SignUpForm {

	@NotBlank
	private String userId;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String roleId;
	
	/**
	 * @return the roleId
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
