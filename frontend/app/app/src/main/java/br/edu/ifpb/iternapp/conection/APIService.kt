package br.edu.ifpb.iternapp.conection

import br.edu.ifpb.iternapp.entities.*
import io.reactivex.Observable
import retrofit2.http.*

interface APIService {

    /***********
     * Student *
     ***********/
    @GET("student/signin")
    fun signinStudent(@Header("email") email: String,
                      @Header("password") password: String): Observable<Response>

    @POST("student")
    fun insertStudent(@Body student: Student): Observable<Response>

    @GET("student")
    fun getAllStudent(): Observable<List<Student>>

    @PUT("student/{id}")
    fun updateStudent(@Path("id") id: Int, @Body student: Student): Observable<Response>

    @DELETE("student/{id}")
    fun deleteStudent(@Path("id") id: Int): Observable<Response>

    @GET("student/{id}")
    fun getStudentById(@Path("id") id: Int): Observable<Student>

    @POST("student/phone")
    fun insertStudentPhone(@Body phone: Phone): Observable<Response>

    @GET("student/phone/{id}")
    fun getAllStudentPhoneById(@Header("id") id: Int): Observable<List<Phone>>

    @POST("student/course")
    fun insertStudentCourse(@Body course: Course): Observable<Response>

    @GET("student/course/{id}")
    fun getALLStudentCourseById(@Header("id") id: Int): Observable<List<Course>>

    /***********
     * Company *
     ***********/
    @GET("company/signin")
    fun signinCompany(@Header("email") email: String,
                      @Header("password") password: String): Observable<Response>

    @GET("company/{id}")
    fun getCompanyById(@Path("id") id: Int): Observable<Company>

    @PUT("company/{id}")
    fun updateCompany(@Path("id") id: Int, @Body company: Company): Observable<Response>

    @POST("company")
    fun insertCompany(@Body company: Company): Observable<Response>

    @DELETE("company/{id}")
    fun deleteCompany(@Path("id") id: Int): Observable<Response>

    /***********
     * Vacancy *
     ***********/
    @POST("vacancy")
    fun insertVacancy(@Body vacancy: VacancyInsert): Observable<Response>

    @GET("vacancy")
    fun getAllVacancy(): Observable<List<Vacancy>>

    @GET("vacancy/{student_id}")
    fun getAllVacancyNoRegister(@Path("student_id") id: Int): Observable<List<Vacancy>>

    @GET("student/vacancy/{student_id}")
    fun getVacanciesRegister(@Path("student_id") id: Int): Observable<List<Vacancy>>

    @POST("vacancy/register")
    fun registerVacancyStudent(@Header("student_id") student_id: Int,
                               @Header("vacancy_id") vacancy_id: Int): Observable<Response>

    @GET("company/vacancy/{id}")
    fun getAllVacancyByCompany(@Path("id") id: Int): Observable<List<Vacancy>>


    /***********
     * Network *
     ***********/
    @POST("network")
    fun insertNetwork(@Body network: Network): Observable<Response>
}