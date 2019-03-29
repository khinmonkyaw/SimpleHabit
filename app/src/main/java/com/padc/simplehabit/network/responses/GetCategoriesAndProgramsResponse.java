package com.padc.simplehabit.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padc.simplehabit.data.vos.CategoriesProgramsVO;

import java.util.List;

public class GetCategoriesAndProgramsResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private String page;

    @SerializedName("categoriesPrograms")
    private List<CategoriesProgramsVO> categoriesProgramsList;


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<CategoriesProgramsVO> getCategoriesProgramsList() {
        return categoriesProgramsList;
    }

    public boolean isResponseSuccessful()
    {
        return code==200;
    }
}
