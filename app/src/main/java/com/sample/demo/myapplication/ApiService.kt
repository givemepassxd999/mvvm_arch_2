package tw.com.test.retrofitdemo

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    fun getPosts(): Call<List<Posts>>
}
