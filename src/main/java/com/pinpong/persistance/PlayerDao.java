package com.pinpong.persistance;

import com.pinpong.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PlayerDao extends CrudRepository<Player, String> {

}
