package com.example.bankaccounts.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.util.Patterns;

import com.example.bankaccounts.data.LoginRepository;
import com.example.bankaccounts.data.Result;
import com.example.bankaccounts.data.model.LoggedInUser;
import com.example.bankaccounts.R;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private LoginRepository loginRepository;

    LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public void login(String accountId) {
        // can be launched in a separate asynchronous job
        Result<LoggedInUser> result = loginRepository.login(accountId);

        if (result instanceof Result.Success) {
            LoggedInUser data = ((Result.Success<LoggedInUser>) result).getData();
            loginResult.setValue(new LoginResult(new LoggedInUserView(data.getDisplayAccountId())));
        } else {
            loginResult.setValue(new LoginResult(R.string.login_failed));
        }
    }

    public void loginDataChanged(String accountId) {
        loginFormState.setValue(new LoginFormState(true));
    }

    // A placeholder username validation check
    private boolean isAccountIdValid(String accountId) {
        return true;
    }

}