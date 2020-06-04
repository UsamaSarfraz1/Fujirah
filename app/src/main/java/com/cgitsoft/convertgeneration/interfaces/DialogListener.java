package com.cgitsoft.convertgeneration.interfaces;


import com.cgitsoft.convertgeneration.models.StudentDetail;

public interface DialogListener {
    void btnOk(StudentDetail detail);
    void btnCancel();
}
