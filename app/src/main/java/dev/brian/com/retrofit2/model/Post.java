package dev.brian.com.retrofit2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("id")
    @Expose
    private Integer id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId='" + userId + '\'' +
                ", id=" + id +
                '}';
    }
}
