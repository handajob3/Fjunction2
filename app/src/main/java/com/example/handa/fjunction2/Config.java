package com.example.handa.fjunction2;

/**
 * Created by HANDA on 19-Aug-17.
 */
public class Config {


    //URL to our login.php file
    public static final String LOGIN_URL = "http://handa.16mb.com/login.php";

    //Keys for email and password as defined in our $_POST['key'] in login.php
    public static final String KEY_E_MAIL = "e_mail";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_PHONE_NO = "phone_no";

    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS = "success";

    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
    public static final String SHARED_PREF_NAME = "myloginapp";

    //This would be used to store the email of current logged in user
    public static final String EMAIL_SHARED_PREF = "e_mail";
    public static final String PHONE_SHARED_PREF = "phone_no";

    //We will use this to store the boolean in sharedpreference to track user is loggedin or not
    public static final String LOGGEDIN_SHARED_PREF = "loggedin";
}
