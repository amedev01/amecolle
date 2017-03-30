package jp.co.amedev.amecolle.web.form;

import org.hibernate.validator.constraints.NotBlank;

public class AdminHomeForm {

	@NotBlank
	private long id;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}


}
