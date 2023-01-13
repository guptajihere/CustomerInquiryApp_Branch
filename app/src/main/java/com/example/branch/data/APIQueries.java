package com.example.branch.data;

import com.example.branch.data.bodyModels.LoginBodyData;
import com.example.branch.data.bodyModels.MessageCreateBody;
import com.example.branch.data.dto.LoginResponse;
import com.example.branch.data.dto.MessagesResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;


public interface APIQueries {


    @POST("login")
    Call<LoginResponse> userLogin(@Body LoginBodyData body);


    @GET("messages")
    Call<List<MessagesResponse>> getMessages(@Header("X-Branch-Auth-Token") String token);

    @POST("messages")
    Call<MessagesResponse> createMessages(@Header("X-Branch-Auth-Token") String token, @Body MessageCreateBody body);


}
