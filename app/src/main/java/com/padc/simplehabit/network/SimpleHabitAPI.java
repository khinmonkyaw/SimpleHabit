package com.padc.simplehabit.network;

import com.padc.simplehabit.network.responses.GetCategoriesAndProgramsResponse;
import com.padc.simplehabit.network.responses.GetCurrentProgramResponse;
import com.padc.simplehabit.network.responses.GetTopicsResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SimpleHabitAPI {

    @FormUrlEncoded
    @POST("getTopics.php")
    Call<GetTopicsResponse> getTopics(@Field("access_token") String accessToken, @Field("page") int page );

    @FormUrlEncoded
    @POST("getCurrentProgram.php")
    Call<GetCurrentProgramResponse> getCurrentProgram(@Field("access_token") String accessToken, @Field("page") int page);

    @FormUrlEncoded
    @POST("getCategoriesPrograms.php")
    Call<GetCategoriesAndProgramsResponse> getCategoriesAndPrograms (@Field("access_token") String accessToken, @Field("page") int page);



}
