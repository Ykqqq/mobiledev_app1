package com.example.bankaccounts.ui.login;

/**
 * Class exposing authenticated user details to the UI.
 */
class LoggedInUserView {
    private String displayAccountId;
    //... other data fields that may be accessible to the UI

    LoggedInUserView(String displayAccountId) {
        this.displayAccountId = displayAccountId;
    }

    String getDisplayAccountId() {
        return displayAccountId;
    }
}