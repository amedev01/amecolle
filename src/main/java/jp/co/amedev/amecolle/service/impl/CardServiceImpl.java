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
import jp.co.amedev.amecolle.repository.entity.MCardEntity;
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

	//cardテーブルへの保存処理
	public void saveGatyaResult(MCardEntity gatyaResult){
		int testUserId = 5; //User aaa → userを持ってくる処理も必要
		CardEntity card = cardRepository.findOne((long)testUserId);
		
		//no_1から回してNULLに入れる処理
			if(card.getNo1() == null){
			// インサート処理・・・pullOne.cardIdをNULL部分に挿入
				
				card.setNo1(gatyaResult.getCardId().toString());

			} else if(card.getNo2() == null){
				
				card.setNo2(gatyaResult.getCardId().toString());

			} else if(card.getNo3() == null){
				
				card.setNo3(gatyaResult.getCardId().toString());

			} else if(card.getNo4() == null){
				
				card.setNo4(gatyaResult.getCardId().toString());

			} else if(card.getNo5() == null){
				
				card.setNo5(gatyaResult.getCardId().toString());

			} else if(card.getNo6() == null){
				
				card.setNo6(gatyaResult.getCardId().toString());

			} else if(card.getNo7() == null){
				
				card.setNo7(gatyaResult.getCardId().toString());

			} else if(card.getNo8() == null){
				
				card.setNo8(gatyaResult.getCardId().toString());

			} else if(card.getNo9() == null){
				
				card.setNo9(gatyaResult.getCardId().toString());

			} else if(card.getNo10() == null){
				
				card.setNo10(gatyaResult.getCardId().toString());

			} else if(card.getNo11() == null){
				
				card.setNo11(gatyaResult.getCardId().toString());

			} else if(card.getNo12() == null){
				
				card.setNo12(gatyaResult.getCardId().toString());

			} else if(card.getNo13() == null){
				
				card.setNo13(gatyaResult.getCardId().toString());

			} else if(card.getNo14() == null){
				
				card.setNo14(gatyaResult.getCardId().toString());

			} else if(card.getNo15() == null){
				
				card.setNo15(gatyaResult.getCardId().toString());

			} else if(card.getNo16() == null){
				
				card.setNo16(gatyaResult.getCardId().toString());

			} else if(card.getNo17() == null){
				
				card.setNo17(gatyaResult.getCardId().toString());

			} else if(card.getNo18() == null){
				
				card.setNo18(gatyaResult.getCardId().toString());

			} else if(card.getNo19() == null){
				
				card.setNo19(gatyaResult.getCardId().toString());

			} else if(card.getNo20() == null){
				
				card.setNo20(gatyaResult.getCardId().toString());

			} else if(card.getNo21() == null){
				
				card.setNo21(gatyaResult.getCardId().toString());

			} else if(card.getNo22() == null){
				
				card.setNo22(gatyaResult.getCardId().toString());

			} else if(card.getNo23() == null){
				
				card.setNo23(gatyaResult.getCardId().toString());

			} else if(card.getNo24() == null){
				
				card.setNo24(gatyaResult.getCardId().toString());

			} else if(card.getNo25() == null){
				
				card.setNo25(gatyaResult.getCardId().toString());

			} else if(card.getNo26() == null){
				
				card.setNo26(gatyaResult.getCardId().toString());

			} else if(card.getNo27() == null){
				
				card.setNo27(gatyaResult.getCardId().toString());

			} else if(card.getNo28() == null){
				
				card.setNo28(gatyaResult.getCardId().toString());

			} else if(card.getNo29() == null){
				
				card.setNo29(gatyaResult.getCardId().toString());

			} else if(card.getNo30() == null){
				
				card.setNo30(gatyaResult.getCardId().toString());
			}
			cardRepository.save(card);
		
		
	}

}
