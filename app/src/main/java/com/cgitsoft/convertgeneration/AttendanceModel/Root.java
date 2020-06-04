package com.cgitsoft.convertgeneration.AttendanceModel;

import java.util.ArrayList;
import java.util.List;
public class Root
{
    private String status;

    private List<Details> details;

    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setDetails(List<Details> details){
        this.details = details;
    }
    public List<Details> getDetails(){
        return this.details;
    }
}
