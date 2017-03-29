package jp.co.amedev.amecolle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.amedev.amecolle.repository.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{
	UserEntity findOneByUserId(String userId);
}
