package com.example.bankaccounts.ui.login;

import androidx.annotation.Nullable;

/**
 * Data validation state of the login form.
 */
class LoginFormState {
    @Nullable
    private Integer accountIdError;
    @Nullable
    private boolean isDataValid;

    LoginFormState(@Nullable Integer accountIdError) {
        this.accountIdError = accountIdError;
        this.isDataValid = false;
    }

    LoginFormState(boolean isDataValid) {
        this.accountIdError = null;
        this.isDataValid = isDataValid;
    }

    @Nullable
    Integer getAccountIdError() {
        return accountIdError;
    }

    boolean isDataValid() {
        return isDataValid;
    }
}