package jp.co.amedev.amecolle.web.form;

import java.util.ArrayList;
import java.util.List;

import jp.co.amedev.amecolle.repository.entity.MCardEntity;
import jp.co.amedev.amecolle.web.form.base.BaseForm;

public class DeckHomeForm extends BaseForm {

	private Long cardId;
	
	private String cardName;
	
	private String hitPoint;
	
	private String attack;
	
	private String rarity;
	
	private List<MCardEntity> mCardList = new ArrayList<>();

	private List<MCardEntity> userCardList = new ArrayList<>();
	
	public List<MCardEntity> getUserCardList() {
		return userCardList;
	}

	public void setUserCardList(List<MCardEntity> userCardList) {
		this.userCardList = userCardList;
	}

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getHitPoint() {
		return hitPoint;
	}

	public void setHitPoint(String hitPoint) {
		this.hitPoint = hitPoint;
	}

	public String getAttack() {
		return attack;
	}

	public void setAttack(String attack) {
		this.attack = attack;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public List<MCardEntity> getmCardList() {
		return mCardList;
	}

	public void setmCardList(List<MCardEntity> mCardList) {
		this.mCardList = mCardList;
	}	 
}
