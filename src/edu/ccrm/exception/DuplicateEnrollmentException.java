// FileName: DuplicateEnrollmentException.java
package edu.ccrm.exception;

/**
 * A custom checked exception thrown when an attempt is made to create a duplicate enrollment.
 */
public class DuplicateEnrollmentException extends Exception {

    /**
     * Constructs a new DuplicateEnrollmentException with the specified detail message.
     * @param message the detail message.
     */
    public DuplicateEnrollmentException(String message) {
        super(message); // Calls the constructor of the parent Exception class [cite: 276]
    }
}