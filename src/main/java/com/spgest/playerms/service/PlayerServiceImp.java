package com.spgest.playerms.service;

import com.spgest.playerms.domain.Player;
import com.spgest.playerms.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayerServiceImp implements PlayerService{

    @Autowired
    private final PlayerRepository playerRepository;

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
}
