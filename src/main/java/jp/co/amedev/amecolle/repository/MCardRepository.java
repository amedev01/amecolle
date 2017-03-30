package jp.co.amedev.amecolle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.amedev.amecolle.repository.entity.MCardEntity;

@Repository
public interface MCardRepository extends JpaRepository<MCardEntity, Long>{

}
