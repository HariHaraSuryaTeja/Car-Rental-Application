package com.finalproject.carrentalsv3;

public class User {
    private int Id;
    private String FirstName, LastName, Email, Password, Mobile;

    public User(int id, String firstName, String lastName, String email, String password, String mobile) {
        Id = id;
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Password = password;
        Mobile = mobile;
    }

    public int getId() {
        return Id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getMobile() {
        return Mobile;
    }
}