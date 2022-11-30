package com.questionnaires.questionnaireapp.entity.securityEntity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public enum Role {
    ROLE_USER(Set.of(Permission.QUESTIONNAIRES_READ)),
    ROLE_ADMIN(Set.of(Permission.QUESTIONNAIRES_READ, Permission.QUESTIONNAIRES_WRITE));

    private final Set<Permission> permissions;

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
