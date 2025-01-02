package com.thanhdon.identity_service.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

import com.thanhdon.identity_service.validator.DobConstraint;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Size(min = 4, message = "USERNAME_INVALID")
    String username;

    @Size(min = 6, message = "INVALID_PASSWORD")
    String password;
    @Size(min = 10,max = 10, message = "INVALID_PHONE_NUMBER")
    String phoneNumber;
    String gender;
    String firstName;
    String lastName;
    String address;


    @DobConstraint(min = 10, message = "INVALID_DOB")
    LocalDate dob;
}