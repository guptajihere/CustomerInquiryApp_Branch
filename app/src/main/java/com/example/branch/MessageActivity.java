package com.example.branch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.branch.data.APIQueries;
import com.example.branch.data.APISingleton;
import com.example.branch.data.dto.MessagesResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        if (getIntent() != null) {
            String accessToken = getIntent().getStringExtra("token");
            getMessage(accessToken);
        }
    }

    private void getMessage(String token) {
        APIQueries singleton = APISingleton.networkRequests();
        Call<List<MessagesResponse>> getMessages = singleton.getMessages(token);
        getMessages.enqueue(new Callback<List<MessagesResponse>>() {
            @Override
            public void onResponse(Call<List<MessagesResponse>> call, Response<List<MessagesResponse>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<MessagesResponse> listOfMessage = response.body();
                    //here u have list, render it on a recycler view to display items
                } else {
                    //do something if there is some network issue
                }
            }

            @Override
            public void onFailure(Call<List<MessagesResponse>> call, Throwable t) {
                //do something if there is some network issue
            }
        });
    }
}