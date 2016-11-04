package com.eolalla.marvelist.network;

import com.eolalla.marvelist.BuildConfig;
import com.eolalla.marvelist.Utils.MD5Digest;

import java.io.IOException;
import java.util.Date;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ernesto Olalla on 26/10/16.
 */

public class ApiServiceProvider {

    private static final String PARAM_API_KEY = "apikey";
    private static final String PARAM_HASH = "hash";
    private static final String PARAM_TIMESTAMP = "ts";

    private static final String BASE_URL = "http://gateway.marvel.com/v1/public/";

    private Retrofit mRetrofit;

    public ApiServiceProvider init() {

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        String timestamp = String.valueOf(new Date().getTime());
                        String hash = MD5Digest.getMD5Hash(timestamp + BuildConfig.PRIVATE_KEY + BuildConfig.PUBLIC_KEY);
                        Request request = chain.request();
                        HttpUrl url = request.url().newBuilder()
                                .addQueryParameter(PARAM_API_KEY, BuildConfig.PUBLIC_KEY)
                                .addQueryParameter(PARAM_HASH, hash)
                                .addQueryParameter(PARAM_TIMESTAMP, timestamp)
                                .build();
                        request = request.newBuilder().url(url).build();
                        return chain.proceed(request);
                    }
                }).build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return this;
    }

    public MarvelService provideMarvelService() {
        return mRetrofit.create(MarvelService.class);
    }
}
