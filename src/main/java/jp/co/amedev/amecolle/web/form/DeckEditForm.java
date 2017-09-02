package jp.co.amedev.amecolle.web.form;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.amedev.amecolle.web.form.base.BaseForm;

public class DeckEditForm extends BaseForm {

	@NotBlank
	public String outDeck;
	@NotBlank
	public String inDeck;
	
	public String getOutDeck() {
		return outDeck;
	}
	public void setOutDeck(String outDeck) {
		this.outDeck = outDeck;
	}
	public String getInDeck() {
		return inDeck;
	}
	public void setInDeck(String inDeck) {
		this.inDeck = inDeck;
	}
	
	
}
