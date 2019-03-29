package com.padc.simplehabit.data.models;

import android.util.Log;

import com.padc.simplehabit.data.vos.CategoriesProgramsVO;
import com.padc.simplehabit.data.vos.ProgramsVO;
import com.padc.simplehabit.delegates.CategoriesAndProgramsResponseDelegate;
import com.padc.simplehabit.network.DataAgent;
import com.padc.simplehabit.network.RetrofitDA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoriesAndProgramsModelImpl implements CategoriesAndProgramsModel {

    private static CategoriesAndProgramsModelImpl objInstance;
    private DataAgent dataAgent;
    private Map<String, ProgramsVO> programsMap;

    private CategoriesAndProgramsModelImpl() {
        dataAgent = RetrofitDA.getObjInstance();
        programsMap = new HashMap<>();
    }

    public static CategoriesAndProgramsModelImpl getObjInstance() {
        if (objInstance == null) {
            objInstance = new CategoriesAndProgramsModelImpl();
        }
        return objInstance;
    }

    @Override
    public void getCategoriesAndPrograms(String accessToken, int page, final CategoriesAndProgramsDelegate delegate) {

        dataAgent.getCategoriesAndPrograms(accessToken, page, new CategoriesAndProgramsResponseDelegate() {
            @Override
            public void onSuccess(List<CategoriesProgramsVO> categoriesProgramsList) {
                setProgramsMap(categoriesProgramsList);
                delegate.onSuccess(categoriesProgramsList);
            }

            @Override
            public void onFail(String errorMessage) {

                delegate.onFail(errorMessage);

            }
        });


    }

    private void setProgramsMap(List<CategoriesProgramsVO> categoriesProgramsList) {


        for (CategoriesProgramsVO c : categoriesProgramsList) {

            for (ProgramsVO p : c.getProgramsList()) {

                programsMap.put(p.getProgramId(), p);


            }
        }


    }


    public ProgramsVO getProgramById(String programId) {
        return programsMap.get(programId);
    }

}
