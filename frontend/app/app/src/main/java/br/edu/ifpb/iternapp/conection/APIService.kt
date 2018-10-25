package br.edu.ifpb.iternapp.conection

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.POST

import retrofit2.http.Body

interface APIService {

    // Student ----------
    @POST("student")
    fun insertStudent() : Unit


    @GET("student")
    fun signinStudent(@Body email: String, @Body password: String) : String

}