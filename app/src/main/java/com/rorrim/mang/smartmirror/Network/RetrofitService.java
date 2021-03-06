package com.rorrim.mang.smartmirror.Network;

import com.rorrim.mang.smartmirror.Model.JSonMessage;
import com.rorrim.mang.smartmirror.Model.User;


import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface RetrofitService {
    @POST("/sendImage")
    @Multipart
    Call<ResponseBody> sendImage(
            @Part MultipartBody.Part image,
            @Part("uid") RequestBody uid,
            @Part("mirrorUid") RequestBody mirrorUid
    );

    @GET("/sendSwitchStatus")
    Call<String> sendSwitchStatus(
            @Query("uid") String uid,
            @Query("activityName") String activityName,
            @Query("isChecked") boolean isChecked,
            @Query("mirrorUid") String mirrorUID
    );

    @POST("/sendCategory")
    Call<ResponseBody> sendCategory(
            @Query("uid") String uid,
            @Query("category") String category,
            @Query("mirrorUid") String mirrorUID
    );

    @POST("/sendLocation")
    Call<ResponseBody> sendLocation(
            @Query("latitude") String latitude,
            @Query("longitude") String longitude,
            @Query("uid") String uid
    );

    @POST("/setMirror")
    Call<String> sendMirrorData(
            @Query("uid") String uid,
            @Query("mirrorUid") String mirrorUid,
            @Query("email") String email
    );
/*
    @GET("/receieMusic")
    Call<ResponseBody> receiveMusic(
            @Query("uid") String uid
    //        @Body String fileName
    );
*/
    @GET("/getPlayList")
    Call<HashMap<String, String>> getPlayList(
            @Query("uid") String uid,
            @Query("mirrorUid") String mirrorUid
    );

    @GET("/getMusic")
    Call<String> pushMusic(
            @Query("uid") String uid,
            @Query("mirrorUid") String mirrorUid,
            @Query("fileName") String fileName
    );

    @GET("/removeMusic")
    Call<String> popMusic(
            @Query("uid") String uid,
            @Query("mirrorUid") String mirrorUid,
            @Query("fileName") String fileName,
            @Query("artist") String artist,
            @Query("song") String song
    );

    @GET("/setName")
    Call<String> sendName(
            @Query("uid") String uid,
            @Query("name") String name
    );

    /*
    @Multipart
    @POST("/sendFile")
    Call<ResponseBody> sendFIle(
            @Part MultipartBody.Part file,
            @Part("uid") String uid,
            @Part("title") String title,
            @Part("artist") String artist
    );


    @Multipart
    @POST("/sendFile")
    Call<ResponseBody> sendFIle(
            @Part MultipartBody.Part file,
            @Part("uid") RequestBody uid,
            @Part("title") RequestBody title,
            @Part("artist") RequestBody artist
    );


    @Multipart
    @POST("/sendImage")
    Call<ResponseBody> sendImage(
            @Part MultipartBody.Part file,
            @Part("name") RequestBody name
    );

    @GET("/recieve_file")
    Call<ResponseBody> recieveFile(
            @Query("fileName") String fileName
            @Body String fileName
    );

    @POST("/recieve_image")
    Call<ResponseBody> recieveImage(
            @Url String imageUrl
    );

    //Start with / neans Absolute route
    @GET("/repos/{owner}/{repo}/contributors")
    Call<List<User>> repoContributors(
            @Path("owner") String owner,
            @Path("repo") String repo);

    //Start without / means Relative route
    @GET("repos/{owner}/{repo}/contributors")
    Call<List<User>> repoContri(@Url String url);

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<User> getAnswers(@Query("tagged") String tags);
    */

}
