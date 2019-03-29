package com.padc.simplehabit.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoriesProgramsVO {

    @SerializedName("category-id")
    private String categoryId;

    @SerializedName("title")
    private String title;

    @SerializedName("programs")
    private List<ProgramsVO> programsList;



    public String getCategoryId() {
        return categoryId;
    }

    public String getTitle() {
        return title;
    }

    public List<ProgramsVO> getProgramsList() {
        return programsList;
    }
}
