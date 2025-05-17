package com.example.money.enums;

public enum TransactionType {

    INCOME("income"),
    TRANSFER("transfer"),
    EXPENSE("expense");

    private String value;
    TransactionType(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    public static TransactionType findTransactionType(String value) {
        for (TransactionType transactionType : TransactionType.values()) {
            if (value.equals(transactionType.getValue())) {
                return transactionType;
            }
        }
        throw new IllegalArgumentException();
    }

}
