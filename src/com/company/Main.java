package com.company;

import com.company.truecaller.Application;
import com.company.truecaller.Call;
import com.company.truecaller.PickCall;
import com.company.truecaller.User;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        //initialize system
        Application system = Application.UNIQUE_INSTANCE;
        system.initialize();

        //create user and register
        User aaryan = new User("Aaryan", "7465764544");
        system.register(aaryan);

        //Add contacts
        User akshay = new User("Akshay","7755057995");
        aaryan.addContact(akshay);

        //check contacts count
        System.out.println("contact count: "+aaryan.getContacts().size());

        //search by mobile
        User searchUserByMobile = aaryan.searchContactByMobile("7755057995");
        System.out.println("search result: "+searchUserByMobile.getName());

        //search by name
        List<User> searchUserByName = aaryan.searchContactByName("Akshay");
        System.out.println("search result: "+searchUserByName.size());

        //make call
        Call call = new Call();
        PickCall pickCall = new PickCall(aaryan,call);
        call.makeCall(new User("Abhay","9934696937"));
        System.out.println("isRinging: "+pickCall.isRinging());

        //block contact
        aaryan.blockContact(akshay);
        call.makeCall(akshay);
        System.out.println("isRinging: "+pickCall.isRinging());

        //unblockContact
        aaryan.unblockContact(akshay);
        call.makeCall(akshay);
        System.out.println("isRinging: "+pickCall.isRinging());
    }
}
