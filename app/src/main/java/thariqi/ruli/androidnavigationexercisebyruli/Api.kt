package thariqi.ruli.androidnavigationexercisebyruli

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("users")
    fun getProducts(): Call<UsersResponse>
}