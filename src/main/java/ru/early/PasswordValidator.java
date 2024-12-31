package ru.early;

public class PasswordValidator {
    private static final String[] FORBIDDEN = {"qwerty", "12345", "password",
            "admin", "user"};

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        boolean letterUpper = false;
        boolean letterLower = false;
        boolean digit = false;
        boolean specSymbol = false;
        for (char ch: password.toCharArray()) {
            if (letterUpper && letterLower && digit && specSymbol) {
                break;
            }
            if (Character.isUpperCase(ch)) {
                letterUpper = true;
            }
            if (Character.isLowerCase(ch)) {
                letterLower = true;
            }
            if (Character.isDigit(ch)) {
                digit = true;
            }
            if (!Character.isLetterOrDigit(ch)) {
                specSymbol = true;
            }
        }
        if (!letterUpper) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!letterLower) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!digit) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!specSymbol) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        for (String words: FORBIDDEN) {
            for (int start = 0; start < password.length() - 1; start++) {
                int finish = start + words.length();
                if (finish > password.length()) {
                    finish = password.length() - 1;
                }
                String valid = password.substring(start, finish);
                if (valid.equalsIgnoreCase(words)) {
                    throw new IllegalArgumentException("Password shouldn't contain substrings: " +
                            "qwerty, 12345, password, admin, user");
                }
            }
        }
        return password;
    }
}

