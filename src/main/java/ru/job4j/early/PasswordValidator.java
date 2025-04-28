package ru.job4j.early;

public class PasswordValidator {
    private static final String[] FORBIDDEN = {"qwerty", "12345", "password", "admin", "user"};

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        PasswordFeatures res = PasswordFeatures.isCase(password);
        if (!res.hasUpCase) {
            throw new IllegalArgumentException(
                    "Password should contain at least one uppercase letter"
            );
        }
        if (!res.hasLowCase) {
            throw new IllegalArgumentException(
                    "Password should contain at least one lowercase letter"
            );
        }
        if (!res.hasDigit) {
            throw new IllegalArgumentException(
                    "Password should contain at least one figure"
            );
        }
        if (!res.hasSpecial) {
            throw new IllegalArgumentException(
                    "Password should contain at least one special symbol"
            );
        }
        if (!res.hasSubs()) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }

    private record PasswordFeatures(boolean hasUpCase, boolean hasLowCase, boolean hasDigit, boolean hasSpecial,
                                    boolean hasSubs) {

        public static PasswordFeatures isCase(String password) {
            boolean hasUpCase = false;
            boolean hasLowCase = false;
            boolean hasDigit = false;
            boolean hasSpecial = false;
            boolean hasSubs = true;
            for (String i : FORBIDDEN) {
                if (password.toLowerCase().contains(i.toLowerCase())) {
                    hasSubs = false;
                    break;
                }
            }
            for (char symbol : password.toCharArray()) {
                if (Character.isUpperCase(symbol)) {
                    hasUpCase = true;
                }
                if (Character.isLowerCase(symbol)) {
                    hasLowCase = true;
                }
                if (Character.isDigit(symbol)) {
                    hasDigit = true;
                }
                if (!Character.isLetterOrDigit(symbol)) {
                    hasSpecial = true;
                }
            }
            return new PasswordFeatures(hasUpCase, hasLowCase, hasDigit, hasSpecial, hasSubs);
        }
    }
}
