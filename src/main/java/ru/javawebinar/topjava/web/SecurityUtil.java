package ru.javawebinar.topjava.web;

import static ru.javawebinar.topjava.util.MealsUtil.DEFAULT_CALORIES_PER_DAY;

public class SecurityUtil {
    private static final int DEFAULT_AUTH_USER_ID = 1;
    private static int authUserId = DEFAULT_AUTH_USER_ID;

    public static int getAuthUserId() {
        return authUserId;
    }

    public static void setAuthUserId(int newAuthUserId){
        authUserId = newAuthUserId;
    }

    public static int authUserCaloriesPerDay() {
        return DEFAULT_CALORIES_PER_DAY;
    }
}