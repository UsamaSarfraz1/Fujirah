package com.Fujairah.convertgeneration.models.login;

public class UserDetail {
    private String user_id;
    private String username;
    private String user_email;
    private String user_phone ;
    private String user_password;
    private String user_fullname;
    private String user_branch;
    private String user_address;
    private String user_cnic;
    private String designation;
    private String user_status;
    private String user_created_id;
    private String user_add_date;
    private String user_pic;


    public UserDetail(String user_id, String username, String user_email, String user_phone, String user_fullname, String user_address, String user_cnic, String user_pic) {
        this.user_id = user_id;
        this.username = username;
        this.user_email = user_email;
        this.user_phone = user_phone;
        this.user_fullname = user_fullname;
        this.user_address = user_address;
        this.user_cnic = user_cnic;
        this.user_pic = user_pic;
    }

    public UserDetail() {
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_fullname() {
        return user_fullname;
    }

    public void setUser_fullname(String user_fullname) {
        this.user_fullname = user_fullname;
    }

    public String getUser_branch() {
        return user_branch;
    }

    public void setUser_branch(String user_branch) {
        this.user_branch = user_branch;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_cnic() {
        return user_cnic;
    }

    public void setUser_cnic(String user_cnic) {
        this.user_cnic = user_cnic;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getUser_status() {
        return user_status;
    }

    public void setUser_status(String user_status) {
        this.user_status = user_status;
    }

    public String getUser_created_id() {
        return user_created_id;
    }

    public void setUser_created_id(String user_created_id) {
        this.user_created_id = user_created_id;
    }

    public String getUser_add_date() {
        return user_add_date;
    }

    public void setUser_add_date(String user_add_date) {
        this.user_add_date = user_add_date;
    }

    public String getUser_pic() {
        return user_pic;
    }

    public void setUser_pic(String user_pic) {
        this.user_pic = user_pic;
    }
}
