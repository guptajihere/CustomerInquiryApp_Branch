package com.example.branch.data.dto;

public class MessagesResponse {
    int id;
    int thread_id;
    String user_id;
    String agent_id;
    String body;
    String timestamp;

    public MessagesResponse(int id, int thread_id, String user_id, String agent_id, String body, String timestamp) {
        this.id = id;
        this.thread_id = thread_id;
        this.user_id = user_id;
        this.agent_id = agent_id;
        this.body = body;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getThread_id() {
        return thread_id;
    }

    public void setThread_id(int thread_id) {
        this.thread_id = thread_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(String agent_id) {
        this.agent_id = agent_id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
