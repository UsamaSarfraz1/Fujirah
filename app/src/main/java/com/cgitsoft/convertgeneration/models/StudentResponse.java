package com.cgitsoft.convertgeneration.models;

public class StudentResponse {
    private StudentDetail deatils;

    private String message;

    private String status;

    public StudentDetail getDeatils ()
    {
        return deatils;
    }

    public void setDeatils (StudentDetail deatils)
    {
        this.deatils = deatils;
    }

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
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
        return "ClassPojo [deatils = "+deatils+", message = "+message+", status = "+status+"]";
    }
}
