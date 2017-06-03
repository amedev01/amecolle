package jp.co.amedev.amecolle.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.amedev.amecolle.repository.MCardRepository;
import jp.co.amedev.amecolle.repository.entity.MCardEntity;
import jp.co.amedev.amecolle.service.MCardService;
	
	@Service
	@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
	public class MCardServiceImpl implements MCardService {

		@Autowired
		MCardRepository mCardRepository;

		
		@Transactional
		public MCardEntity pullOneCharacter() {
			List<MCardEntity> mCardList = mCardRepository.findAll();
			
			Random rnd = new Random();
			int mother = rnd.nextInt(99);
			int rarity=0;
			if (mother < 59) {
				rarity = 1;
			} else if (mother < 79) {
				rarity = 2;
			} else if (mother < 92 ) {
				rarity = 3;
			}else if (mother < 98 ) {
				rarity = 4;
			}else if (mother == 99 ) {
				rarity = 5;
			}
			
			List<MCardEntity> listPerRarity = new ArrayList<MCardEntity>();
			for (MCardEntity pullOne : mCardList){
				if(pullOne.getRarity().equals(String.valueOf(rarity))){
					listPerRarity.add(pullOne);
				};
			}
			/*listPerRarityからランダムにひとつ返す処理を作る またカウント
			*/
			int rarityCount = listPerRarity.size();
			
			int num = rnd.nextInt(rarityCount);

			MCardEntity gatyaResult = new MCardEntity();
			gatyaResult = listPerRarity.get(num);
			
//			return pullCard;
			return gatyaResult;
		}

		
	}

