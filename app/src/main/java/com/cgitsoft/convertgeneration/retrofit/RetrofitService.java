package com.cgitsoft.convertgeneration.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static OkHttpClient okHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();
    private final static String BaseURL ="http://developers.cgitsoft.com/";
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BaseURL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    public static <S> S createService(Class<S> serviceClass){
        return retrofit.create(serviceClass);
    }
}
