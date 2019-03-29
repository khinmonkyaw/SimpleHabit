package com.padc.simplehabit.delegates;

import com.padc.simplehabit.data.vos.CategoriesProgramsVO;

import java.util.List;

public interface CategoriesAndProgramsResponseDelegate {

    void onSuccess(List<CategoriesProgramsVO> categoriesProgramsList);
    void onFail(String errorMessage);
}
