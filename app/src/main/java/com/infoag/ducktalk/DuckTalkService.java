package com.infoag.ducktalk;

import com.infoag.ducktalk.models.Contact;
import com.infoag.ducktalk.models.Message;
import com.infoag.ducktalk.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DuckTalkService {
    @GET("users")
    Call<List<User>> getUserList();

    @POST("users")
    Call<Void> createUser(@Body User user);

    @GET("users/{username}")
    Call<User> getUserData(@Path("username") String username,
                           @Header("Authorization") String authorization);

    @POST("users/{username}/contacts")
    Call<Void> addContact(@Path("username") String username, @Body Contact contact,
                          @Header("Authorization") String authorization);

    @POST("messages")
    Call<Void> sendMessage(@Body Message message, @Header("Authorization") String authorization);

    @FormUrlEncoded
    @GET("messages")
    Call<List<Message>> getMessages(@Field("sender") String sender,
                                    @Field("recipient") String recipient,
                                    @Header("Authorization") String authorization);
}
