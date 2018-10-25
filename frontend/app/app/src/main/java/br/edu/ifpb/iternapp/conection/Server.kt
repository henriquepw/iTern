package br.edu.ifpb.iternapp.conection

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Server {
    var retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.0.198:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    var service = retrofit.create(APIService::class.java)
}