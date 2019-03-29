package com.padc.simplehabit.data.models;

import android.util.Log;

import com.padc.simplehabit.data.vos.CurrentProgramVO;
import com.padc.simplehabit.delegates.CurrentProgramResponseDelegate;
import com.padc.simplehabit.network.DataAgent;
import com.padc.simplehabit.network.RetrofitDA;

public class CurrentProgramModelImpl implements CurrentProgramModel {

    private static  CurrentProgramModelImpl objInstance;
    private DataAgent dataAgent;
    private CurrentProgramVO mcurrentProgramVO;

    private CurrentProgramModelImpl() {
        dataAgent = RetrofitDA.getObjInstance();
    }

    public static CurrentProgramModelImpl getObjInstance() {
        if(objInstance == null)
        {
            objInstance = new CurrentProgramModelImpl();
        }
        return objInstance;
    }

    @Override
    public void getCurrentProgram(String accessToken, int page, final CurrentProgramDelegate delegate) {

        dataAgent.getCurrentProgram(accessToken, page, new CurrentProgramResponseDelegate() {
            @Override
            public void onSuccess(CurrentProgramVO currentProgram) {

                mcurrentProgramVO = currentProgram;
                delegate.onSuccess(currentProgram);
            }

            @Override
            public void onFail(String errorMessage) {
                delegate.onFail(errorMessage);
            }
        });




    }


    public CurrentProgramVO getMcurrentProgramVO() {
        return mcurrentProgramVO;
    }
}
