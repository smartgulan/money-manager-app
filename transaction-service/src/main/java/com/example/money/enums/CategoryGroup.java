package com.example.money.enums;

public enum CategoryGroup {

    DEBT("debt"),
    ESTATE("estate"),
    PERSONAL("personal"),
    FOOD("food"),
    OTHER("other");

    private String value;
    CategoryGroup(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    public static CategoryGroup fromValue(String value) {
        for (CategoryGroup categoryGroup : CategoryGroup.values()) {
            if (categoryGroup.getValue().equals(value)) {
                return categoryGroup;
            }
        }
        throw new IllegalArgumentException();
    }

}
