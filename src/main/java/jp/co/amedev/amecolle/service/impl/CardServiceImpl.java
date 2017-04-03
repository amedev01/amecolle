package jp.co.amedev.amecolle.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.amedev.amecolle.constant.AmecolleConst;
import jp.co.amedev.amecolle.repository.CardRepository;
import jp.co.amedev.amecolle.repository.entity.CardEntity;
import jp.co.amedev.amecolle.service.CardService;

@Service
public class CardServiceImpl implements CardService{

	@Autowired
	CardRepository cardRepository;
	
	public void saveNew(long id){
		CardEntity card = new CardEntity();
		card.setId(id);
		cardRepository.save(card);
	}
	
	@Override
	public List<String> getCardIdList(long id) {
		List<String> cardIdList = new ArrayList<String>();
		CardEntity card = cardRepository.findOne(id);
		
		try{
		@SuppressWarnings("unchecked")
		Map<String, String> map = BeanUtils.describe(card);
		for(int i = 1; i <= AmecolleConst.CARD_NUM_MAX; i++){
			if(map.get("no" + i) != null){
			cardIdList.add((String)map.get("no" + i));
			}
		}
		}catch(Exception e){
			throw new RuntimeException();
		}
		
		return cardIdList;
	}
}
