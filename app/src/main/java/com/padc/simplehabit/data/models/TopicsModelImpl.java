package com.padc.simplehabit.data.models;

import android.util.Log;

import com.padc.simplehabit.data.vos.TopicsVO;
import com.padc.simplehabit.delegates.TopicsResponseDelegate;
import com.padc.simplehabit.network.DataAgent;
import com.padc.simplehabit.network.RetrofitDA;

import java.util.List;

public class TopicsModelImpl implements TopicsModel {

    private static  TopicsModelImpl objInstance;
    private DataAgent dataAgent;

    private TopicsModelImpl() {
        dataAgent = RetrofitDA.getObjInstance();
    }

    public static TopicsModelImpl getObjInstance() {
        if(objInstance == null)
        {
            objInstance = new TopicsModelImpl();
        }
        return objInstance;
    }

    @Override
    public void getTopics(String accessToken, int page, final TopicDelegate delegate) {

        dataAgent.getTopics(accessToken, page, new TopicsResponseDelegate() {
            @Override
            public void onSuccess(List<TopicsVO> topicsList) {
                //Log.e("GetTopics",topicsVOList.get(0).getTopicName());
                delegate.onSuccess(topicsList);
            }

            @Override
            public void onFail(String errorMessage) {

              //  Log.e("error", errorMessage);
                delegate.onFail(errorMessage);


            }
        });

    }





}
