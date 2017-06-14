package com.vasyaevstropov.retrofitrxjavatestapp;


import com.google.gson.annotations.SerializedName;

public class MessageModel
{
    @SerializedName("status")
    private String status;
    @SerializedName("data")
    private Data[] data;

    public String getStatus ()
    {
        return status;
    }

    public Data[] getData ()
    {
        return data;
    }

}
