package com.Fujairah.convertgeneration.dialogs;


import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.Fujairah.convertgeneration.R;
import com.Fujairah.convertgeneration.interfaces.DialogListener;

public class LoginDialog extends DialogFragment {

    private static final String TAG =LoginDialog.class.getSimpleName();

    private View v;
    private EditText fEmail,fPassword;
    private TextView errorMessage,btnLogin,btnCancel;
    private ProgressBar progressBar;
    private static DialogListener listener;

    public static LoginDialog newInstance(DialogListener dialogListener){
        listener = dialogListener;
        return new LoginDialog();}

    public LoginDialog() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.dialog_login, container, false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        init();

        return v;
    }

    private void init() {
        fEmail = v.findViewById(R.id.txt_email);
        fPassword = v.findViewById(R.id.txt_password);
        errorMessage = v.findViewById(R.id.errorMessage);
        progressBar = v.findViewById(R.id.progressBar);
        btnCancel = v.findViewById(R.id.btn_cancel);
        btnLogin = v.findViewById(R.id.btn_login);

        btnCancel.setOnClickListener(cancel -> dismiss());
        btnLogin.setOnClickListener(login -> validateFields());
    }

    private void validateFields() {
        if(errorMessage.getVisibility() == View.VISIBLE){
            errorMessage.setVisibility(View.GONE);
        }
        String email =fEmail.getText().toString().trim();
        String password = fPassword.getText().toString().trim();
        if(email.isEmpty()){
            fEmail.setError("Field Required");
            fEmail.setShowSoftInputOnFocus(true);
            fEmail.setFocusableInTouchMode(true);
            return;
        }
        if(password.isEmpty()){
            fPassword.setError("Field Required");
            fPassword.setShowSoftInputOnFocus(true);
            fPassword.setFocusableInTouchMode(true);
            return;
        }
        loginUser(email,password);
    }
    private void loginUser(String email, String password) {
        /*progressBar.setVisibility(View.VISIBLE);
        CGITAPIs api = RetrofitService.createService(CGITAPIs.class);
        api.getStudentResponse(email,password).enqueue(new Callback<StudentResponse>() {
            @Override
            public void onResponse(Call<StudentResponse> call, Response<StudentResponse> response) {
                if(response.isSuccessful()){
                    StudentResponse studentResponse = response.body();
                    if(studentResponse != null && studentResponse.getStatus().equals("200")){
                        listener.btnOk(studentResponse.getDeatils());
                    }else {
                        errorMessage.setText("Wrong email or password");
                        errorMessage.setVisibility(View.VISIBLE);
                    }
                }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<StudentResponse> call, Throwable t) {
                errorMessage.setText(t.getMessage());
                errorMessage.setVisibility(View.VISIBLE);
                Log.e(TAG,t.getMessage());
                progressBar.setVisibility(View.GONE);
            }
        });*/
    }

    @Override
    public void onResume() {
        Window window = getDialog().getWindow();
        Point size = new Point();

        // Store dimensions of the screen in `size`
        Display display = window.getWindowManager().getDefaultDisplay();
        display.getSize(size);

        // Set the width of the dialog proportional to 90% of the screen width
        window.setLayout((int) (size.x * 0.90), WindowManager.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);

        // Call super onResume after sizing
        super.onResume();
    }
}
