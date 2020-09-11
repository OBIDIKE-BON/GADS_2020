package com.stackfloat.gads2020.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface LeadersService {
    @GET("api/hours")
    Call<List<LearnerLeader>> getLearnerLeaders();

    @GET("api/skilliq")
    Call<List<IQLeader>> getIQLeaders();

//    @Headers("text/html")
    @FormUrlEncoded
    @POST
    Call<Void> submitForm(
            @Url String altUrl,
            @Field("entry.1824927963") String EmailAddress ,
            @Field("entry.1877115667") String Name ,
            @Field("entry.2006916086") String LastName,
            @Field("entry.284483984") String projectLink);
}
