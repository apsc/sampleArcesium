package com.arcesium.excpetion;

/**
 * Created by amanpsc on 12/11/15.
 */
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
