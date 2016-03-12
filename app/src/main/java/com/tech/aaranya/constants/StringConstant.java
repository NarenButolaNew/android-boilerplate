package com.tech.aaranya.constants;

/**
 * Created by test on 3/6/16.
 */
public interface StringConstant {

    String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    String MOBILE_PATTERN = "^\\d{10}$";
    String NUMERIC_PATTERN = "^\\d+$";
    String AUTH_SUCCESSFUL = "auth successful";
    String FIREBASE_BASE_URL = "https://random12.firebaseio.com";
    String INVALID_MOBILE_NUMBER = "Invalid Mobile number!";
    String INVALID_EMAIL_ID = "Invalid Email Id!";
    String INVALID_PASSWORD = "Invalid Password";
    String AUTHENTICATING_THE_USER = "Authenticating the user...";
    String PASSWORD = "password";
    String SPACE = " ";
}
