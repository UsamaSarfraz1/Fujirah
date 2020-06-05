package com.Fujairah.convertgeneration.models;

public class AttendanceDetail {
    private String teacher_id;

    private String att_id;

    private String student_id;

    private String att_sts;

    private String att_date;

    public String getTeacher_id ()
    {
        return teacher_id;
    }

    public void setTeacher_id (String teacher_id)
    {
        this.teacher_id = teacher_id;
    }

    public String getAtt_id ()
    {
        return att_id;
    }

    public void setAtt_id (String att_id)
    {
        this.att_id = att_id;
    }

    public String getStudent_id ()
    {
        return student_id;
    }

    public void setStudent_id (String student_id)
    {
        this.student_id = student_id;
    }

    public String getAtt_sts ()
    {
        return att_sts;
    }

    public void setAtt_sts (String att_sts)
    {
        this.att_sts = att_sts;
    }

    public String getAtt_date ()
    {
        return att_date;
    }

    public void setAtt_date (String att_date)
    {
        this.att_date = att_date;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [teacher_id = "+teacher_id+", att_id = "+att_id+", student_id = "+student_id+", att_sts = "+att_sts+", att_date = "+att_date+"]";
    }
}
