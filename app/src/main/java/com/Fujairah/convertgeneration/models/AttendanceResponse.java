package com.Fujairah.convertgeneration.models;

public class AttendanceResponse {
    private AttendanceDetail[] deatils;

    private String message;

    private String status;

    public AttendanceDetail[] getDeatils ()
    {
        return deatils;
    }

    public void setDeatils (AttendanceDetail[] deatils)
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
