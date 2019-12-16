package com.sample.demo.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InfoViewModel(var infoRepository: InfoRepository): ViewModel() {
    private var userInfoLiveData = MutableLiveData<String>()
    fun callInfo():LiveData<String>{
        infoRepository.loadInfo(object : OnTaskFinish {
            override fun onFinish(data: String) {
                userInfoLiveData.postValue(data)
            }
        })
        return userInfoLiveData
    }
}