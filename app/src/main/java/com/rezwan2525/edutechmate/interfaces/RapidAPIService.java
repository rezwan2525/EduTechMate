package com.rezwan2525.edutechmate.interfaces;

import com.rezwan2525.edutechmate.models.WhatsAppMessage;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RapidAPIService {

    //


    @Headers({
            "Accept: application/json",
            "Authorization: 617bf1f9245383001100f805"
    })
    @GET("bulksms/bulksms")
    Call<ResponseBody> sendSMS(
            @Query("username") String username,
            @Query("password") String password,
            @Query("type") int type,
            @Query("dlr") int dlr,
            @Query("destination") String destination,
            @Query("source") String source,
            @Query("message") String message);

    @Headers({ "Accept: application/json","Authorization: 617bf1f9245383001100f805"})
    @POST("wbm/v1/message")
    Call<ResponseBody> sendWhatsApp(
            @Body WhatsAppMessage message);
}
