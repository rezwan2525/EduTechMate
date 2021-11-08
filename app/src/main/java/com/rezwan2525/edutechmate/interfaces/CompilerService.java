package com.rezwan2525.edutechmate.interfaces;

import com.rezwan2525.edutechmate.models.CompilerFinal;
import com.rezwan2525.edutechmate.models.CompilerFirst;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface CompilerService {

    @FormUrlEncoded
    @POST("main.php")
    Call<CompilerFirst> compilerFirstCall(
            @Field("lang")String lang,
            @Field("code")String code,
            @Field("input")String input,
            @Field("save")boolean save
    );

    @FormUrlEncoded
    @POST("submissionResult.php")
    Call<CompilerFinal> compilerFinalCall(
            @Field("sid")String sid,
            @Field("requestType")String requestType
    );

}
