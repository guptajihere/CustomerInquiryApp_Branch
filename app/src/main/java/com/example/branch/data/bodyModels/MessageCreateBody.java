package com.example.branch.data.bodyModels;

public class MessageCreateBody {

    int thread_id;
    String body;

    public MessageCreateBody(int thread_id, String body) {
        this.thread_id = thread_id;
        this.body = body;
    }

    public int getThread_id() {
        return thread_id;
    }

    public void setThread_id(int thread_id) {
        this.thread_id = thread_id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
