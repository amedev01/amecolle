package jp.co.amedev.amecolle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.amedev.amecolle.repository.entity.DeckEntity;

@Repository
public interface DeckRepository extends JpaRepository<DeckEntity, Long> {
	DeckEntity findOneById(long id);
	
	List<DeckEntity> findByIdNot(long id);
	
}
