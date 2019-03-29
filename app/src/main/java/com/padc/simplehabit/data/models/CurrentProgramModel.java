package com.padc.simplehabit.data.models;

import com.padc.simplehabit.data.vos.CurrentProgramVO;

public interface CurrentProgramModel {

    void getCurrentProgram(String accessToken,int page,CurrentProgramDelegate delegate);


    interface  CurrentProgramDelegate
    {
        void onSuccess(CurrentProgramVO currentProgram);
        void onFail(String errorMessage);

    }
}
