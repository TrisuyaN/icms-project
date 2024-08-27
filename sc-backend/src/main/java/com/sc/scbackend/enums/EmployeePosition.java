package com.sc.scbackend.enums;


public enum EmployeePosition {
    SUPER_ADMINISTRATOR("Super Administrator"),
    SECURITY_GUARD("Security Guard"),
    CLEANER("Cleaner");

    private final String value;

    EmployeePosition(String value) {
        this.value = value;
    }

}
