package me.sunjin.springbootdeveloper.domain;

import lombok.Getter;

@Getter
public enum UserRole {
    USER("USER"),
    ADMIN("ADMIN");

    private final String value;
    UserRole(String value) {
        this.value = value;
    }
}