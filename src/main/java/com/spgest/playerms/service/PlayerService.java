package com.spgest.playerms.service;


import com.spgest.playerms.dto.PlayerCreationDTO;
import com.spgest.playerms.dto.PlayerDTO;

import java.util.List;
import java.util.Optional;

public interface PlayerService {

    List<PlayerDTO> getAllPlayers();

    Optional<PlayerDTO> getPlayerByEmail(String email);

    void savePlayer(PlayerCreationDTO playerCreationDTO);
}
