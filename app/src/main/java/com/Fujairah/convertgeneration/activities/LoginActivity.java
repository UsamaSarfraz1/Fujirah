package com.Fujairah.convertgeneration.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.Fujairah.convertgeneration.Dashboard;
import com.Fujairah.convertgeneration.R;
import com.Fujairah.convertgeneration.dialogs.LoginDialog;
import com.Fujairah.convertgeneration.interfaces.DialogListener;
import com.Fujairah.convertgeneration.models.SharedPref;
import com.Fujairah.convertgeneration.models.Utills;
import com.Fujairah.convertgeneration.models.Utils;
import com.Fujairah.convertgeneration.models.login.LoginResponse;
import com.Fujairah.convertgeneration.retrofit.CGITAPIs;
import com.Fujairah.convertgeneration.retrofit.RetrofitService;
import com.google.android.material.textfield.TextInputEditText;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.Fujairah.convertgeneration.Constants.PERMISSION_CAMERA;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG =LoginDialog.class.getSimpleName();

    private TextInputEditText fEmail,fPassword;
    private TextView errorMessage;
    private TextView btnLogin;
    private AVLoadingIndicatorView progressBar;
    private static DialogListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //setupUI(findViewById(R.id.parent));

        // making toolbar transparent
        transparentToolbar();

        init();
        //TextView btnLogin = findViewById(R.id.btn_login);
        //btnLogin.setOnClickListener(login -> checkPermission());
    }

    private void init() {
        fEmail = findViewById(R.id.txt_email);
        fPassword = findViewById(R.id.txt_password);
        errorMessage = findViewById(R.id.errorMessage);
        progressBar =findViewById(R.id.progressBar);
        progressBar.hide();
        btnLogin = findViewById(R.id.btn_login);
        Utills.checkConnection(this,errorMessage);
        btnLogin.setOnClickListener(login -> checkPermission());
    }

    private void validateFields() {
        if(errorMessage.getVisibility() == View.VISIBLE){
            errorMessage.setVisibility(View.GONE);
        }
        String email = Objects.requireNonNull(fEmail.getText()).toString().trim();
        String password = Objects.requireNonNull(fPassword.getText()).toString().trim();
        if(email.isEmpty()){
            fEmail.setError("Field Required");
            fEmail.setShowSoftInputOnFocus(true);
            fEmail.setFocusableInTouchMode(true);
            btnLogin.setEnabled(true);
            return;
        }
        /*if(password.isEmpty()){
            fPassword.setError("Field Required");
            fPassword.setShowSoftInputOnFocus(true);
            fPassword.setFocusableInTouchMode(true);
            return;
        }*/
        loginUser(email,password);
    }

    private void loginUser(String email, String password) {
        btnLogin.setEnabled(false);
        progressBar.show();
        CGITAPIs api = RetrofitService.createService(CGITAPIs.class);
        api.getStudentResponse(email,password).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    LoginResponse loginResponse = response.body();
                    if(loginResponse != null && loginResponse.getCode().equals("200")){
                        SharedPref pref = new SharedPref(loginResponse.getUser_details().getUser_id(),true);
                        Utils.setSharedPref(getApplicationContext(),pref);
                        Utills.setProfileData(loginResponse.getUser_details(),LoginActivity.this);
                        if(loginResponse.getUser_role()[0].equals("administrator")){
                            Utils.setIsAdmin(LoginActivity.this,true);
                            Utils.openActivity(LoginActivity.this,Dashboard.class);
                            finishAffinity();
                        }else if(loginResponse.getUser_role()[0].equals("employee")){
                            Utils.setIsAdmin(LoginActivity.this,false);
                            Utils.openActivity(LoginActivity.this,Dashboard.class);
                            finishAffinity();
                        }else {
                            errorMessage.setText("User role undefined.");
                            errorMessage.setVisibility(View.VISIBLE);
                        }

                    }else {
                        errorMessage.setText("Wrong email or password");
                        errorMessage.setVisibility(View.VISIBLE);
                    }
                }
                progressBar.hide();
                btnLogin.setEnabled(true);
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call,@NonNull Throwable t) {
                errorMessage.setText(t.getMessage());
                errorMessage.setVisibility(View.VISIBLE);
                Log.e(TAG, Objects.requireNonNull(t.getMessage()));
                progressBar.hide();
                btnLogin.setEnabled(true);
            }
        });
    }

    private void checkPermission() {
        btnLogin.setEnabled(false);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
            validateFields();
        }else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                new AlertDialog.Builder(this).
                        setTitle("Permission needed")
                        .setMessage("Camera permission needed for this app to work. Grant permission")
                        .setNegativeButton("No",((dialog, which) -> {
                            dialog.dismiss();
                        }))
                        .setPositiveButton("Ok",((dialog, which) ->
                                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},PERMISSION_CAMERA)))
                        .show();
            }else {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},PERMISSION_CAMERA);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_CAMERA) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                validateFields();
            }
        }
    }
    private void transparentToolbar() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private void setWindowFlag(Activity activity) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        winParams.flags &= ~WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        win.setAttributes(winParams);
    }
    public void setupUI(View view) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    Utils.hideSoftKeyboard(LoginActivity.this);
                    return false;
                }
            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView);
            }
        }


    }

}
