package com.example.aakash.rozgarinepal;

public class user_details {
    String user_id,user_name,user_address,user_contact,user_email,user_quali,user_experience,user_skills;
    public user_details()
    {}

    public user_details( String user_name,String user_address, String user_contact, String user_email, String user_quali, String user_experience, String user_skills) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_address = user_address;
        this.user_contact = user_contact;
        this.user_email = user_email;
        this.user_quali = user_quali;
        this.user_experience = user_experience;
        this.user_skills = user_skills;
    }

    public String getUser_id() { return user_id; }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_contact() {
        return user_contact;
    }

    public void setUser_contact(String user_contact) {
        this.user_contact = user_contact;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_quali() {
        return user_quali;
    }

    public void setUser_quali(String user_quali) {
        this.user_quali = user_quali;
    }

    public String getUser_experience() {
        return user_experience;
    }

    public void setUser_experience(String user_experience) {
        this.user_experience = user_experience;
    }

    public String getUser_skills() {
        return user_skills;
    }

    public void setUser_skills(String user_skills) {
        this.user_skills = user_skills;
    }
}
