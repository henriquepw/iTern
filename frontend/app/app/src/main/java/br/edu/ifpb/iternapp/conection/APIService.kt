package br.edu.ifpb.iternapp.conection

import br.edu.ifpb.iternapp.entities.*
import io.reactivex.Observable
import retrofit2.http.*

interface APIService {

    /************
     *  Student *
     ************/

    @GET("student/signin")
    fun signinStudent(@Header("email") email: String,
                      @Header("password") password: String): Observable<Response>

    @POST("student")
    fun insertStudent(@Body student: Student): Observable<Response>

    @GET("student")
    fun getAllStudent(): Observable<List<Student>>

    @PUT("student")
    fun updateStudent(@Body student: Student): Observable<Response>

    @DELETE("student/{id}")
    fun deleteStudent(@Path("id") id: Int): Observable<String>

    @GET("student/{id}")
    fun getByIdStudent(@Path("id") id: Int): Observable<List<Student>>

    @POST("student/phone")
    fun insertStudentPhone(@Body phone: Phone): Observable<Response>

    @GET("student/phone/{id}")
    fun getAllStudentPhoneById(@Header("id") id: Int): Observable<List<Phone>>

    @POST("student/course")
    fun insertStudentCourse(@Body course: Course): Observable<Response>

    @GET("student/course/{id}")
    fun getALLStudentCourseById(@Header("id") id: Int): Observable<List<Course>>

    /************
     *  Company *
     ************/

    @GET("company/signin")
    fun signinCompany(@Header("email") email: String,
                      @Header("password") password: String): Observable<Response>

    @POST("company")
    fun insertCompany(@Body company: Company): Observable<Response>

    @DELETE("company/{id}")
    fun deleteCompany(@Path("id") id: Int): Observable<String>
}