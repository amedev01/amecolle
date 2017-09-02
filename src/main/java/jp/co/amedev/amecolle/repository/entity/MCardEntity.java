package jp.co.amedev.amecolle.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_card")
public class MCardEntity {

	@Id
	@Column(name="card_id")
	private Long cardId;
	
	@Column(name="card_name")
	private String cardName;
	
	@Column(name="hit_point")
	private String hitPoint;
	
	@Column(name="attack")
	private String attack;
	
	@Column(name="rarity")
	private String rarity;
	
	@Column(name="url")
	private String url;

	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
}
