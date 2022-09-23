package com.spgest.playerms.dto;

import com.spgest.playerms.domain.Address;
import com.spgest.playerms.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PlayerCreationDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String msisdn;
    private Address address;
    private Gender gender;
    private String dob;
}
