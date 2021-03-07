package com.example.bankaccounts.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String userId;
    private String displayAccountId;

    public LoggedInUser(String userId, String displayAccountId) {
        this.userId = userId;
        this.displayAccountId = displayAccountId;
    }

    public String getUserId() {
        return userId;
    }

    public String getDisplayAccountId() {
        return displayAccountId;
    }
}