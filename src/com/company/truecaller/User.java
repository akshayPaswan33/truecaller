package com.company.truecaller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private final String name;
    private final String mobile;
    private int spamCount = 0;

    private final Map<String, User> contacts;
    private final Map<String, User> blockedContacts;

    public User(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;

        contacts = new HashMap<>();
        blockedContacts = new HashMap<>();
    }

    public void addContact(User user) {
        contacts.put(user.getMobile(), user);
    }

    public void blockContact(User user) {
        blockedContacts.put(user.getMobile(), user);
    }

    public void unblockContact(User user) {
        blockedContacts.remove(user.getMobile());
    }

    public void reportSpam(User user) {
        user.updateSpamCount();
    }

    public User searchContactByMobile(String mobile) {
        User user = contacts.get(mobile);
        if(user==null) {
            Application system = Application.UNIQUE_INSTANCE;
            user = system.searchByMobile(mobile);
        }
        return user;
    }

    public List<User> searchContactByName(String name) {
        List<User> users = new ArrayList<>();
        for(User user : contacts.values()) {
            if(user.getName().equals(name)) users.add(user);
        }
        return users;
    }

    public boolean isDiallerBlocked(String mobile) {
        return blockedContacts.containsKey(mobile);
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public void updateSpamCount() {
        spamCount++;
    }

    public int getSpamCount() {
        return spamCount;
    }

    public Map<String, User> getContacts() {
        return contacts;
    }
}
