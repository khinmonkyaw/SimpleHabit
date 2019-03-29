package com.padc.simplehabit.data.models;

import com.padc.simplehabit.data.vos.TopicsVO;

import java.util.List;

public interface TopicsModel {


    void getTopics(String accessToken,int page,TopicDelegate delegate);


    interface TopicDelegate
    {
        void onSuccess(List<TopicsVO> topicsList);
        void onFail(String errorMessage);
    }
}
