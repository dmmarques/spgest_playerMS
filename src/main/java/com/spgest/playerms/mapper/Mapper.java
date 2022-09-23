package com.spgest.playerms.mapper;

import com.spgest.playerms.domain.Address;
import com.spgest.playerms.domain.Player;
import com.spgest.playerms.dto.PlayerCreationDTO;
import com.spgest.playerms.dto.PlayerDTO;
import com.spgest.playerms.enums.Gender;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public PlayerDTO playerToDto(Player player){
        String name = player.getFirstName();
        String email = player.getEmail();
        Address address = new Address(
                player.getAddress().getCountry(),
                player.getAddress().getStreetName(),
                player.getAddress().getZipCode()
        );

        return new PlayerDTO(name, email, address);
    }

    /*
    Method to map a creationDTO sent by the user to be saved in the DB as a regular domain (Player)
     */
    public Player creationDtoToPlayer(PlayerCreationDTO playerCreationDTO){
        String fname = playerCreationDTO.getFirstName();
        String lname = playerCreationDTO.getLastName();
        String email = playerCreationDTO.getEmail();
        String phoneNumber = playerCreationDTO.getMsisdn();
        Address address = playerCreationDTO.getAddress();
        Gender gender = playerCreationDTO.getGender();
        String dob = playerCreationDTO.getDob();
        return new Player(fname, lname, email, phoneNumber, address, gender, dob);
    }

}
