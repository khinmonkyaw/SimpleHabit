package com.padc.simplehabit.network;

import com.padc.simplehabit.delegates.CategoriesAndProgramsResponseDelegate;
import com.padc.simplehabit.delegates.CurrentProgramResponseDelegate;
import com.padc.simplehabit.delegates.TopicsResponseDelegate;

public interface DataAgent {


    void getTopics(String accessToken, int page, TopicsResponseDelegate delegate);
    void getCategoriesAndPrograms(String accessToken, int page, CategoriesAndProgramsResponseDelegate delegate);
    void getCurrentProgram(String accessToken,int page,CurrentProgramResponseDelegate delegate);
}
