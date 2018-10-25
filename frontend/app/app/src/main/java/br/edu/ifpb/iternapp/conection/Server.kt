package br.edu.ifpb.iternapp.conection

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Server {
    fun init() {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.0.198:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}