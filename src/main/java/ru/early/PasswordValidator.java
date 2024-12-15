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
        int letterUpper = 0;
        int letterLower = 0;
        int digit = 0;
        char[] ch = password.toCharArray();
        int specSymbol = 0;
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isUpperCase(ch[i])) {
                letterUpper++;
            }
            if (!Character.isLowerCase(ch[i])) {
                letterLower++;
            }
            if (!Character.isDigit(ch[i])) {
                digit++;
            }
            if (!Character.isLetterOrDigit(ch[i])) {
                specSymbol++;
            }
        }
        if (letterUpper == password.length()) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (letterLower == password.length()) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (digit == password.length()) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (specSymbol == 0) {
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

