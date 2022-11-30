package com.questionnaires.questionnaireapp.entity.securityEntity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permission {
    QUESTIONNAIRES_READ("questionnaires:read"),
    QUESTIONNAIRES_WRITE("questionnaires:write");

    private final String permission;
}
