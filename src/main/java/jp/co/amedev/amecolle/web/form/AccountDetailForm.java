package jp.co.amedev.amecolle.web.form;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.amedev.amecolle.web.form.base.BaseForm;

public class AccountDetailForm extends BaseForm {

	@NotBlank	
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
