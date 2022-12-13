package com.questionnaires.questionnaireapp.dto.security;

import lombok.Data;

@Data
public class RegistrationRequestDTO {
    private String email;
    private String password;
    private String first_name;
    private String last_name;
}
