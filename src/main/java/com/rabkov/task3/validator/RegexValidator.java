package com.rabkov.task3.validator;

import java.util.regex.Pattern;

public class RegexValidator {

    public boolean validateRegex(String string) {
        Pattern pattern =
                Pattern.compile("^((\\s+)?(-?\\d+(\\.\\d+)?+\\s+)){3}(\\d+((\\.\\d+)?\\s?))(\\s+)?$");
        return pattern.matcher(string).matches();
    }
}

