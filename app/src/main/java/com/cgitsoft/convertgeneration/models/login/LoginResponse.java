package com.cgitsoft.convertgeneration.models.login;

public class LoginResponse {
    private String[] user_role;

    private String code;

    private UserDetail user_details;

    private String status;

    public String[] getUser_role ()
    {
        return user_role;
    }

    public void setUser_role (String[] user_role)
    {
        this.user_role = user_role;
    }

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    public UserDetail getUser_details ()
    {
        return user_details;
    }

    public void setUser_details (UserDetail user_details)
    {
        this.user_details = user_details;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [user_role = "+user_role+", code = "+code+", user_details = "+user_details+", status = "+status+"]";
    }
}
