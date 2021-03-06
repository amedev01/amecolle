package jp.co.amedev.amecolle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.amedev.amecolle.repository.entity.CardEntity;
import jp.co.amedev.amecolle.repository.entity.UserEntity;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, Long> {

}
