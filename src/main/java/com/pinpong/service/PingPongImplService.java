package com.pinpong.service;

import com.pinpong.model.Player;
import com.pinpong.persistance.PlayerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PingPongImplService implements PingPongService {

    @Autowired
    private PlayerDao playerDao;

    @Override
    public List<Player> getAllPlayer() {
        return (List<Player>) playerDao.findAll();
    }
}
