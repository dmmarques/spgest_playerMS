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
    // The field below shows how we can map a field to a different field name in the DB
    // @Field("nameOnDB") is the field name in the DB to be mapped against the class var name
    @Field("zipcode")
    private String zipCode;
}
