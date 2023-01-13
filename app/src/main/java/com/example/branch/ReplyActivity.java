package com.example.branch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.branch.data.APIQueries;
import com.example.branch.data.APISingleton;
import com.example.branch.data.bodyModels.MessageCreateBody;
import com.example.branch.data.dto.MessagesResponse;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReplyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);

        if (getIntent() != null) {
             //use the inputs of the user in editext and call the API after checking if the inputs are not empty
            String token = getIntent().getStringExtra("token");
//            createMessageReply(token, .., ..);
        }

    }

    private void createMessageReply(String token, int rand, String message) {
        APIQueries singleton = APISingleton.networkRequests();
        Call<MessagesResponse> create = singleton.createMessages(token, new MessageCreateBody(rand, message));
        create.enqueue(new Callback<MessagesResponse>() {
            @Override
            public void onResponse(Call<MessagesResponse> call, Response<MessagesResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    //here message has been created. Do changes in UI u want
                } else {
                    //do something if there is some creating messaging failure
                }
            }

            @Override
            public void onFailure(Call<MessagesResponse> call, Throwable t) {
                //do something if there is some network issue
            }
        });
    }
}