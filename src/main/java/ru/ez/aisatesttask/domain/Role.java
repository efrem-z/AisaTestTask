package ru.ez.aisatesttask.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    CLIENT,
    ADMIN,
    BEST_CLIENT;

    @Override
    public String getAuthority() {
        return name();
    }
}