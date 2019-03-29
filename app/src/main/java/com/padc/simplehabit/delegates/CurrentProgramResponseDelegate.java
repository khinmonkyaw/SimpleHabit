package com.padc.simplehabit.delegates;

import com.padc.simplehabit.data.vos.CurrentProgramVO;

public interface CurrentProgramResponseDelegate {

    void onSuccess(CurrentProgramVO currentProgram);

    void onFail(String errorMessage);
}
