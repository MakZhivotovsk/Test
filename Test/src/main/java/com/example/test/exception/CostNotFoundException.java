package com.example.test.exception;

public class CostNotFoundException extends RuntimeException {
    public CostNotFoundException() {
        super("Could not get cost for product");
    }
}
