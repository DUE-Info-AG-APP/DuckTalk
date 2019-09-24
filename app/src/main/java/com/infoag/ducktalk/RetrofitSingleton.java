package com.infoag.ducktalk;

import java.util.Optional;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RetrofitSingleton {
    private static DuckTalkService instance;

    private RetrofitSingleton() {}

    public static synchronized DuckTalkService getInstance() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl("ducktalk.ddns.net")
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
                    .create(DuckTalkService.class);
        }
        return instance;
    }
}
