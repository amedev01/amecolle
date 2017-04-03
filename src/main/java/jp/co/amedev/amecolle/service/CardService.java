package jp.co.amedev.amecolle.service;

import java.util.List;

public interface CardService {

	void saveNew(long id);
	List<String> getCardIdList(long id);
	
}
