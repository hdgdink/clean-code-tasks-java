package com.epam.engx.cleancode.functions.task3;

import com.epam.engx.cleancode.functions.task3.thirdpartyjar.SessionManager;
import com.epam.engx.cleancode.functions.task3.thirdpartyjar.User;
import com.epam.engx.cleancode.functions.task3.thirdpartyjar.UserService;

public abstract class UserAuthenticator implements UserService {
    private SessionManager sessionManager;

    protected UserAuthenticator(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    User loginUser(String userName, String password) {
        if (isPasswordCorrect(getUserByName(userName), password)) {
            sessionManager.setCurrentUser(getUserByName(userName));
            return getUserByName(userName);
        }

        return null;
    }
}