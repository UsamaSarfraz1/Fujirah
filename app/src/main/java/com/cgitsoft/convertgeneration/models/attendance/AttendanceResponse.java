package com.cgitsoft.convertgeneration.models.attendance;

public class AttendanceResponse {
    private AttendanceDetail[] details;

    private String status;

    public AttendanceDetail[] getDetails ()
    {
        return details;
    }

    public void setDetails (AttendanceDetail[] details)
    {
        this.details = details;
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
        return "ClassPojo [details = "+details+", status = "+status+"]";
    }
}
