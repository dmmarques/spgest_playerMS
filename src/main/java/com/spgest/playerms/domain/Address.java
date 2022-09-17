package com.spgest.playerms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String country;
    private String streetName;
    @Field("zipcode")
    private String zipCode;
}
