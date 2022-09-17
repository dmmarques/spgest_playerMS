package com.spgest.playerms.controller;

import com.spgest.playerms.domain.Player;
import com.spgest.playerms.service.PlayerServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path="api/playerms/")
public class PlayerController {

    @Autowired
    private final PlayerServiceImp playerServiceImp;

    @GetMapping(path=("players"))
    public ResponseEntity<List<Player>> getAllPlayers(){
        List<Player> playerList = playerServiceImp.getAllPlayers();
        return new ResponseEntity<>(playerList, HttpStatus.OK);
    }

}
