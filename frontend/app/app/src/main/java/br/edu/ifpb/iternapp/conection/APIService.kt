package br.edu.ifpb.iternapp.conection

import br.edu.ifpb.iternapp.entities.SignIn
import io.reactivex.Observable

import retrofit2.http.GET
import retrofit2.http.POST

import retrofit2.http.Header

interface APIService {

    // Student ----------
    @POST("student")
    fun insertStudent(): Unit


    @GET("student/signin")
    fun signinStudent(@Header("email") email: String,
                      @Header("password") password: String): Observable<SignIn>

}