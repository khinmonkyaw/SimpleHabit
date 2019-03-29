package com.padc.simplehabit.data.models;

import com.padc.simplehabit.data.vos.CategoriesProgramsVO;

import java.util.List;

public interface CategoriesAndProgramsModel {



    void getCategoriesAndPrograms(String accessToken,int page,CategoriesAndProgramsDelegate delegate);

    interface  CategoriesAndProgramsDelegate
     {
         void onSuccess(List<CategoriesProgramsVO > categoriesProgramsList);

         void onFail(String errorMessage);



     }
}
