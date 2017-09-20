package com.ulb.service.generator;

import java.util.concurrent.TimeUnit;

import com.ulb.core.statics.Constant;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wangpeng on 25/07/2017.
 *
 * API service 生成
 */
public class APIServiceGenrator {

//    public static final String TOKEN_KEY = PropertyUtils.getValue("retrofit.tokenKey");
//
//    public static final String TOKEN = PropertyUtils.getValue("retrofit.token");


    /**
     * 带token
     * @param serviceClass
     * @param <S>
     * @return
     */
//    public static <S> S createRequsetServiceWithToken(Class<S> serviceClass) {
//        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
//        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        Interceptor tokenInterceptor = chain -> {
//            Request request = chain.request();
//
//            Request authorised = request.newBuilder()
//                    .header(TOKEN_KEY, TOKEN)
//                    .build();
//            return chain.proceed(authorised);
//        };
//        OkHttpClient client = new OkHttpClient.Builder()
//                .retryOnConnectionFailure(true)
//                .connectTimeout(10, TimeUnit.SECONDS)
//                .readTimeout(30, TimeUnit.SECONDS)
//                .addNetworkInterceptor(tokenInterceptor)
//                .addInterceptor(httpLoggingInterceptor)
//                .build();
//
//        Retrofit builder = new Retrofit.Builder()
//                .client(client)
//                .baseUrl(REQUEST_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        return builder.create(serviceClass);
//    }

    /**
     * 带token
     * @param serviceClass
     * @param <S>
     * @return
     */
    public static <S> S createRequsetService(Class<S> serviceClass) {
//        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
//        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        OkHttpClient client = new OkHttpClient.Builder()
//                .retryOnConnectionFailure(true)
//                .connectTimeout(10, TimeUnit.SECONDS)
//                .readTimeout(30, TimeUnit.SECONDS)
//                .addInterceptor(httpLoggingInterceptor)
//                .build();
//
//        Retrofit builder = new Retrofit.Builder()
//                .client(client)
//                .baseUrl(Constant.REQUEST_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();

//        return builder.create(serviceClass);

        return createRequsetService(serviceClass,Constant.REQUEST_URL);
    }


    public static <S> S createRequsetService(Class<S> serviceClass,String url) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();

        Retrofit builder = new Retrofit.Builder()
                .client(client)
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return builder.create(serviceClass);
    }
}
