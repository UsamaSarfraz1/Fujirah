package com.cgitsoft.convertgeneration.models;

public class StudentDetail {
    private String student_password;

    private String student_class;

    private String student_gender;

    private String student_lname;

    private String student_add_date;

    private String student_phone;

    private String student_id;

    private String student_address;

    private String student_dob;

    private String student_email;

    private String student_fname;

    private String student_pic;

    public String getStudent_password ()
    {
        return student_password;
    }

    public void setStudent_password (String student_password)
    {
        this.student_password = student_password;
    }

    public String getStudent_class ()
    {
        return student_class;
    }

    public void setStudent_class (String student_class)
    {
        this.student_class = student_class;
    }

    public String getStudent_gender ()
    {
        return student_gender;
    }

    public void setStudent_gender (String student_gender)
    {
        this.student_gender = student_gender;
    }

    public String getStudent_lname ()
    {
        return student_lname;
    }

    public void setStudent_lname (String student_lname)
    {
        this.student_lname = student_lname;
    }

    public String getStudent_add_date ()
    {
        return student_add_date;
    }

    public void setStudent_add_date (String student_add_date)
    {
        this.student_add_date = student_add_date;
    }

    public String getStudent_phone ()
    {
        return student_phone;
    }

    public void setStudent_phone (String student_phone)
    {
        this.student_phone = student_phone;
    }

    public String getStudent_id ()
    {
        return student_id;
    }

    public void setStudent_id (String student_id)
    {
        this.student_id = student_id;
    }

    public String getStudent_address ()
    {
        return student_address;
    }

    public void setStudent_address (String student_address)
    {
        this.student_address = student_address;
    }

    public String getStudent_dob ()
    {
        return student_dob;
    }

    public void setStudent_dob (String student_dob)
    {
        this.student_dob = student_dob;
    }

    public String getStudent_email ()
    {
        return student_email;
    }

    public void setStudent_email (String student_email)
    {
        this.student_email = student_email;
    }

    public String getStudent_fname ()
    {
        return student_fname;
    }

    public void setStudent_fname (String student_fname)
    {
        this.student_fname = student_fname;
    }

    public String getStudent_pic ()
    {
        return student_pic;
    }

    public void setStudent_pic (String student_pic)
    {
        this.student_pic = student_pic;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [student_password = "+student_password+", student_class = "+student_class
                +", student_gender = "+student_gender+", student_lname = "+student_lname
                +", student_add_date = "+student_add_date+", student_phone = "+student_phone+", student_id = "+student_id+", student_address = "+student_address+", student_dob = "+student_dob+", student_email = "+student_email+", student_fname = "+student_fname+", student_pic = "+student_pic+"]";
    }
}
