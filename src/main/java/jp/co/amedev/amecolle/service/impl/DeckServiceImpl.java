package jp.co.amedev.amecolle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.amedev.amecolle.repository.DeckRepository;
import jp.co.amedev.amecolle.repository.entity.DeckEntity;
import jp.co.amedev.amecolle.service.DeckService;

@Service
public class DeckServiceImpl implements DeckService{
	
	@Autowired
	DeckRepository deckRepository;
	
	public DeckEntity pullDeck(long userId){
		DeckEntity deckEntity = deckRepository.findOneById(userId);
		return deckEntity;
	}
}
