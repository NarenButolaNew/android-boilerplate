package com.tech.aaranya.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.tech.aaranya.constants.StringConstant.NUMERIC_PATTERN;
import static com.tech.aaranya.constants.StringConstant.EMAIL_PATTERN;
import static com.tech.aaranya.constants.StringConstant.MOBILE_PATTERN;

/**
 * Created by test on 3/6/16.
 */
public class Validator {

    public static final boolean isValidMobileNumber(String string) {
        Pattern pattern = Pattern.compile(MOBILE_PATTERN);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static final boolean isNumeric(String string) {
        Pattern pattern = Pattern.compile(NUMERIC_PATTERN);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }


    // validating email id
    public static final boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // validating password with retype password
    public static final boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 6) {
            return true;
        }
        return false;
    }
}
