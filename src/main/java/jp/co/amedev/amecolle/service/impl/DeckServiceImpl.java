package jp.co.amedev.amecolle.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.amedev.amecolle.repository.DeckRepository;
import jp.co.amedev.amecolle.repository.entity.DeckEntity;
import jp.co.amedev.amecolle.service.DeckService;

@Service
public class DeckServiceImpl implements DeckService{
	
	@Autowired
	DeckRepository deckRepository;
	
	public void update(DeckEntity entity){
		deckRepository.save(entity);
	}
	public DeckEntity pullDeck(long userId){
		DeckEntity deckEntity = deckRepository.findOneById(userId);
		return deckEntity;
	}
	
	// DBから自分以外のユーザのデッキ情報を取得する
	public DeckEntity pullEnemyDeck(long userId){
		List<DeckEntity> deckEntityList = deckRepository.findByIdNot(userId);
		
		int size = deckEntityList.size();
		
		Random rnd = new Random();
		int mother = rnd.nextInt(size);
//		DeckEntity deckEntity = deckRepository.findOneById(mother);
		return deckEntityList.get(mother);
	}
	
}
