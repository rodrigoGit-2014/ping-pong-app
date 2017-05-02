package com.pinpong.controller;

import com.pinpong.model.Player;
import com.pinpong.service.PingPongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/pinpong")
public class PlayerController {

    @Autowired
    private PingPongService pingPongService;

    @RequestMapping(value = "findAllPlayer", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Player> getAllPlayer() {
        return pingPongService.getAllPlayer();
    }
}
