package com.Fujairah.convertgeneration.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.Fujairah.convertgeneration.R;
import com.Fujairah.convertgeneration.models.UpdateProfile.Root;
import com.Fujairah.convertgeneration.models.Utils;
import com.Fujairah.convertgeneration.retrofit.CGITAPIs;
import com.Fujairah.convertgeneration.retrofit.RetrofitService;
import com.google.android.material.textfield.TextInputEditText;
import com.wang.avi.AVLoadingIndicatorView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResetPasswordActivity extends AppCompatActivity {


    TextInputEditText newPassword;
    TextInputEditText confirmPassword;
    TextView resetBtn;
    AVLoadingIndicatorView progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        init();
    }


    private void init(){
        newPassword=findViewById(R.id.new_pass);
        confirmPassword=findViewById(R.id.confirm_pass);
        resetBtn=findViewById(R.id.resetBtn);
        progressBar=findViewById(R.id.progressBar);


        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newPassword.getText().toString().trim().matches("") || confirmPassword.getText().toString().trim().matches("")){
                    Toast.makeText(ResetPasswordActivity.this, "Empty Data", Toast.LENGTH_SHORT).show();
                }
                else if (newPassword.getText().toString().equals(confirmPassword.getText().toString())){
                    ResetPassword(confirmPassword.getText().toString());
                }else {
                    confirmPassword.setError("password does not match");
                    confirmPassword.requestFocus();
                }
            }
        });
    }

    public void Empty(){
        newPassword.setText("");
        confirmPassword.setText("");
    }

    public void ResetPassword(String password){
        progressBar.setVisibility(View.VISIBLE);
        String emp_id= Utils.getSharedPref(this).getId();
        CGITAPIs api = RetrofitService.createService(CGITAPIs.class);
        api.resetPassword(emp_id,password).enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if(response.isSuccessful()){
                    com.Fujairah.convertgeneration.models.UpdateProfile.Root root = response.body();
                    if(root != null && root.getCode().equals("200")){
                        progressBar.setVisibility(View.GONE);
                        Empty();
                        Toast.makeText(ResetPasswordActivity.this, "Password Reset Successfully!!!", Toast.LENGTH_SHORT).show();
                    }else {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(ResetPasswordActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                new AlertDialog.Builder(ResetPasswordActivity.this)
                        .setTitle("Response")
                        .setMessage(t.getMessage())
                        .setPositiveButton("OK",((dialog, which) -> finish())).show();
            }
        });
    }
}
