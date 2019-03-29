package com.padc.simplehabit.delegates;

import com.padc.simplehabit.data.vos.TopicsVO;

import java.util.List;

public interface TopicsResponseDelegate {


    void onSuccess(List<TopicsVO> topicsVOList);

    void  onFail(String errormessage);
}
