package com.padc.simplehabit.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padc.simplehabit.data.vos.TopicsVO;

import java.util.List;

public class GetTopicsResponse {


    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private int page;

    @SerializedName("topics")
    private List<TopicsVO> topics;


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public int getPage() {
        return page;
    }

    public List<TopicsVO> getTopics() {
        return topics;
    }


    public boolean isResponseSuccessful() {
        return code == 200;
    }
}
