package edu.ccrm.util;

import java.util.regex.Pattern;

public final class InputValidator {

    // A simple regex for email validation. For production, a more comprehensive one might be needed.
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE
    );


    private InputValidator() {}


    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }


    public static boolean isNotNullOrEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }


    public static boolean isValidInteger(String input) {
        if (input == null) {
            return false;
        }
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}