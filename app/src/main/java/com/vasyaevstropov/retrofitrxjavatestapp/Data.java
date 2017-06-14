package com.vasyaevstropov.retrofitrxjavatestapp;

import com.google.gson.annotations.SerializedName;

public class Data
{
    @SerializedName("message")
    private String message;

    @SerializedName("id")
    private String id;

    @SerializedName("updated_at")
    private String updated_at;

    @SerializedName("name")
    private String name;

    @SerializedName("created_at")
    private String created_at;

    public String getMessage ()
    {
        return message;
    }

    public String getId ()
    {
        return id;
    }

    public String getUpdated_at ()
    {
        return updated_at;
    }

    public String getName ()
    {
        return name;
    }

    public String getCreated_at ()
    {
        return created_at;
    }


}
