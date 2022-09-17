package com.spgest.playerms.domain;

import com.spgest.playerms.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Player {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String msisdn;
    private Address address;
    private Gender gender;
    private LocalDateTime dob;
    @Transient
    private int age;

}
