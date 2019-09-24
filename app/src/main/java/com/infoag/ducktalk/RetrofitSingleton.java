package com.infoag.ducktalk;

import java.util.Optional;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RetrofitSingleton {
    private static final DuckTalkService instance = new Retrofit.Builder()
            .baseUrl("ducktalk.ddns.net")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(DuckTalkService.class);

    private RetrofitSingleton() {}

    static synchronized DuckTalkService getInstance() {
        return instance;
    }
}
