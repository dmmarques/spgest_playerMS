package com.spgest.playerms.dto;

import com.spgest.playerms.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlayerDTO {
    private String firstName;
    private String email;
    private Address address;
}
