package com.spgest.playerms.service;

import com.spgest.playerms.domain.Player;
import com.spgest.playerms.dto.PlayerCreationDTO;
import com.spgest.playerms.dto.PlayerDTO;
import com.spgest.playerms.mapper.Mapper;
import com.spgest.playerms.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlayerServiceImp implements PlayerService{

    @Autowired
    private final PlayerRepository playerRepository;
    private final Mapper mapper;

    @Override
    public List<PlayerDTO> getAllPlayers() {
        List<Player> playerList = playerRepository.findAll();
        List<PlayerDTO> playerDTOList = playerList.stream().
                map(mapper::playerToDto).
                collect(Collectors.toList());
        return playerDTOList;
    }

    @Override
    public Optional<PlayerDTO> getPlayerByEmail(String email) {
        Optional<Player> optionalPlayer = playerRepository.getPlayerByEmail(email);
        if(optionalPlayer.isPresent()){
            PlayerDTO playerDTO = mapper.playerToDto(optionalPlayer.get());
            return Optional.ofNullable(playerDTO);
        }
        return Optional.empty();
    }

    @Override
    public void savePlayer(PlayerCreationDTO playerCreationDTO) {
        if(getOptionalPlayer(playerCreationDTO.getEmail()).isEmpty()){
            playerRepository.save(mapper.creationDtoToPlayer(playerCreationDTO));
        }
    }

    public void deletePlayer(String email) {
        if(getOptionalPlayer(email).isPresent()){
            playerRepository.delete(getOptionalPlayer(email).get());
        }
    }

    public Optional<Player> getOptionalPlayer(String email){
        Optional<Player> optionalPlayer = playerRepository.getPlayerByEmail(email);
        return optionalPlayer;
    }

}
