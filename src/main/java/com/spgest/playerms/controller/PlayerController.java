package com.spgest.playerms.controller;

import com.spgest.playerms.dto.PlayerCreationDTO;
import com.spgest.playerms.dto.PlayerDTO;
import com.spgest.playerms.service.PlayerServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(path="api/playerms/")
public class PlayerController {

    @Autowired
    private final PlayerServiceImp playerServiceImp;

    @GetMapping(path=("players"))
    @ResponseBody
    public ResponseEntity<List<PlayerDTO>> getAllPlayers(){
        List<PlayerDTO> playerDTOList = playerServiceImp.getAllPlayers();
        return new ResponseEntity<>(playerDTOList, HttpStatus.OK);
    }

    @GetMapping(path = "players/")
    @ResponseBody
    public ResponseEntity<Optional<PlayerDTO>> getPlayerByEmail(@RequestParam String playerEmail){
        Optional<PlayerDTO> optionalPlayerDTO = playerServiceImp.getPlayerByEmail(playerEmail);
        if(optionalPlayerDTO.isEmpty()){
            return new ResponseEntity<>(optionalPlayerDTO, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalPlayerDTO, HttpStatus.OK);
    }

    @PostMapping(path = "players")
    @ResponseBody
    public ResponseEntity<PlayerCreationDTO> savePlayer(@RequestBody PlayerCreationDTO playerCreationDTO){
        String playerEmail = playerCreationDTO.getEmail();
        if(playerServiceImp.getOptionalPlayer(playerEmail).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        playerServiceImp.savePlayer(playerCreationDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "players/{playerEmail}")
    public ResponseEntity<HttpStatus> deletePlayer(@PathVariable String playerEmail){
        if(playerServiceImp.getOptionalPlayer(playerEmail).isPresent()){
            playerServiceImp.deletePlayer(playerEmail);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*
    TODO:
        - Implement:
            - Update (Put)
     */

    @PutMapping
    public ResponseEntity<HttpStatus> updatePlayer(@RequestBody PlayerCreationDTO playerCreationDTO){
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
