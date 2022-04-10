package com.company.truecaller;

import java.util.HashMap;
import java.util.Map;

public enum Application {

    UNIQUE_INSTANCE;

    private Map<String, User> userMap;

    public void register(User user) {
        userMap.put(user.getMobile(), user);
    }

    public void initialize() {
        userMap = new HashMap<>();
        userMap.put("7755057995", new User("Akshay", "7755057995"));
        userMap.put("9934696937", new User("Abhay", "9934696937"));
    }

    public User searchByMobile(String mobile) {
        return userMap.get(mobile);
    }
}
