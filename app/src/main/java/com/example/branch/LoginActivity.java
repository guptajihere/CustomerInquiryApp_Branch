package com.example.branch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.branch.data.APIQueries;
import com.example.branch.data.APISingleton;
import com.example.branch.data.bodyModels.LoginBodyData;
import com.example.branch.data.dto.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText userName, passWd;
    private Button loginMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginMe = findViewById(R.id.submit);
        userName = findViewById(R.id.username);
        passWd = findViewById(R.id.password);

        loginMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs(userName.getText().toString(), passWd.getText().toString())) {
                    login(userName.getText().toString(), passWd.getText().toString());
                } else {
                    Toast.makeText(LoginActivity.this, "Fields cannot be empty!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void login(String username, String passwd) {
        APIQueries singleton = APISingleton.networkRequests();
        Call<LoginResponse> log = singleton.userLogin(new LoginBodyData(username, passwd));

        log.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Intent it = new Intent(LoginActivity.this, MessageActivity.class);
                    it.putExtra("token", response.body().getAuth_token());
                    startActivity(it);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Wrong Credentials! Try with valid inputs", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Check Your internet connection!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validateInputs(String u, String p) {
        if (!u.isEmpty() && !p.isEmpty()) {
            return true;
        }

        return false;
    }
}