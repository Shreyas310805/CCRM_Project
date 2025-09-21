package edu.ccrm.exception;


public class MaxCreditLimitExceededException extends Exception {


    public MaxCreditLimitExceededException(String message) {
        super(message); // Calls the constructor of the parent Exception class [cite: 278]
    }
}