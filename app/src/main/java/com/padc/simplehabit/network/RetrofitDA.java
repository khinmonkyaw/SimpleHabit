package com.padc.simplehabit.network;

import com.google.gson.Gson;
import com.padc.simplehabit.Utils.AppConstants;
import com.padc.simplehabit.data.vos.CurrentProgramVO;
import com.padc.simplehabit.delegates.CategoriesAndProgramsResponseDelegate;
import com.padc.simplehabit.delegates.CurrentProgramResponseDelegate;
import com.padc.simplehabit.delegates.TopicsResponseDelegate;
import com.padc.simplehabit.network.responses.GetCategoriesAndProgramsResponse;
import com.padc.simplehabit.network.responses.GetCurrentProgramResponse;
import com.padc.simplehabit.network.responses.GetTopicsResponse;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDA implements DataAgent {


    private static RetrofitDA objInstance;
    private SimpleHabitAPI mApi;


    private RetrofitDA() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();

        mApi = retrofit.create(SimpleHabitAPI.class);


    }

    public static RetrofitDA getObjInstance() {

        if (objInstance == null) {
            objInstance = new RetrofitDA();
        }

        return objInstance;
    }

    @Override
    public void getTopics(String accessToken, int page, final TopicsResponseDelegate delegate) {


        Call<GetTopicsResponse> getTopicsResponseCall = mApi.getTopics(accessToken, page);

        getTopicsResponseCall.enqueue(new Callback<GetTopicsResponse>() {
            @Override
            public void onResponse(Call<GetTopicsResponse> call, Response<GetTopicsResponse> response) {
                GetTopicsResponse getTopicsResponse = response.body();

                if(getTopicsResponse.isResponseSuccessful())
                {
                    delegate.onSuccess(getTopicsResponse.getTopics());
                }
                else
                {
                    delegate.onFail(getTopicsResponse.getMessage());
                }
            }

            @Override
            public void onFailure(Call<GetTopicsResponse> call, Throwable t) {

                delegate.onFail(t.getMessage());
            }
        });


    }

    @Override
    public void getCurrentProgram(String accessToken, int page, final CurrentProgramResponseDelegate delegate) {

       Call<GetCurrentProgramResponse> getCurrentProgramResponseCall = mApi.getCurrentProgram(accessToken,page);
       getCurrentProgramResponseCall.enqueue(new Callback<GetCurrentProgramResponse>() {

           @Override
           public void onResponse(Call<GetCurrentProgramResponse> call, Response<GetCurrentProgramResponse> response) {
               GetCurrentProgramResponse getCurrentProgramResponse = response.body();

                   if(getCurrentProgramResponse.isResponseSuccessful())
                   {
                       delegate.onSuccess(getCurrentProgramResponse.getCurrentProgram());
                   }
                   else
                   {
                       delegate.onFail(getCurrentProgramResponse.getMessage());
                   }
           }

           @Override
           public void onFailure(Call<GetCurrentProgramResponse> call, Throwable t) {

               delegate.onFail(t.getMessage());

           }
       });
    }

    @Override
    public void getCategoriesAndPrograms(String accessToken, int page, final CategoriesAndProgramsResponseDelegate delegate) {

        final Call<GetCategoriesAndProgramsResponse> getCategoriesAndProgramsResponseCall = mApi.getCategoriesAndPrograms(accessToken, page);

        getCategoriesAndProgramsResponseCall.enqueue(new Callback<GetCategoriesAndProgramsResponse>() {
            @Override
            public void onResponse(Call<GetCategoriesAndProgramsResponse> call, Response<GetCategoriesAndProgramsResponse> response) {

                GetCategoriesAndProgramsResponse getCategoriesAndProgramsResponse = response.body();
               if(getCategoriesAndProgramsResponse.isResponseSuccessful())
                {
                        delegate.onSuccess(getCategoriesAndProgramsResponse.getCategoriesProgramsList());
                }
                else
               {
                   delegate.onFail(getCategoriesAndProgramsResponse.getMessage());
               }


            }

            @Override
            public void onFailure(Call<GetCategoriesAndProgramsResponse> call, Throwable t) {

                delegate.onFail(t.getMessage());
            }
        });
    }


}
