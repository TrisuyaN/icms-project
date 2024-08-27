package com.sc.scbackend.enums;


public enum AccountStatus {
    ACTIVE("Active"),
    INACTIVE("Inactive");

    private final String value;

    AccountStatus(String value) {
        this.value = value;
    }


}

