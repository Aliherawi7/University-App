package com.mycompany.constants;

public enum Degree {
    AS("Associate's Degree"),
    BS("Bachelor's Degree"),
    MA("Mater's Degree"),
    PhD("Doctorate Degree");

    private final String value;

    Degree(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
