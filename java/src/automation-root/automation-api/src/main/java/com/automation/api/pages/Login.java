package com.automation.api.pages;

public interface Login {
    Object forgotCode();
    Object forgotPassword();
    String getLoginMessage();
    Login login(String id, String password, String code);

}
