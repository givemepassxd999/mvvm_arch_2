package com.sample.demo.myapplication

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tw.com.test.retrofitdemo.ApiService
import tw.com.test.retrofitdemo.AppClientManager
import tw.com.test.retrofitdemo.Posts

class InfoRepository {
    fun loadInfo(task: OnTaskFinish) {
        val apiService = AppClientManager.client.create(ApiService::class.java)
        apiService.getPosts().enqueue(object : Callback<List<Posts>> {
            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                val sb = StringBuffer()
                response.body()?.forEach {
                    sb.append(it.body)
                    sb.append("\n")
                    sb.append("---------------------\n")
                }
                task.onFinish(sb.toString())
            }

            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {

            }
        })
    }
}
interface OnTaskFinish {
    fun onFinish(data: String)
}