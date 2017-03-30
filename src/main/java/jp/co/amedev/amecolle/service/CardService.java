package jp.co.amedev.amecolle.service;

import java.util.List;

import jp.co.amedev.amecolle.repository.entity.CardEntity;

public interface CardService {

	void save(CardEntity cardEntity);
	List<String> getCardIdList(long id);
}
