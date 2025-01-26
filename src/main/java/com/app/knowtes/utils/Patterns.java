package com.app.knowtes.utils;

public class Patterns {

    public static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$";
    public static final String NAME_REGEX = "[A-Z][a-z]*([\\s\\'-][A-Z][a-z]*)*$";
}
