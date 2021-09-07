package com.demo.retrofithttpmethods

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel: ViewModel() {
    lateinit var createNewUserLiveData: MutableLiveData<UserResponse?>
    lateinit var loadUserData: MutableLiveData<UserResponse?>

    init {
        createNewUserLiveData = MutableLiveData()
        loadUserData = MutableLiveData()
    }

    fun getCreateNewUserObserver(): MutableLiveData<UserResponse?> {
        return createNewUserLiveData
    }

    fun getLoadUserObserver(): MutableLiveData<UserResponse?> {
        return loadUserData
    }

    fun createNewUser(user: User) {
        val retroService  = RetroInstance.getRetroInstance().create(RetroServiceInterface::class.java)
        val call = retroService.createUser(user)
        call.enqueue(object: Callback<UserResponse> {
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                createNewUserLiveData.postValue(null)
            }

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if(response.isSuccessful) {
                    createNewUserLiveData.postValue(response.body())
                } else {
                    createNewUserLiveData.postValue(null)
                }
            }
        })
    }

    fun loadUserData(user_is: String) {
        val retroService  = RetroInstance.getRetroInstance().create(RetroServiceInterface::class.java)
        val call = retroService.getUser(user_is)
        call.enqueue(object: Callback<UserResponse> {
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                loadUserData.postValue(null)
            }

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if(response.isSuccessful) {
                    loadUserData.postValue(response.body())
                } else {
                    loadUserData.postValue(null)
                }
            }
        })

    }

    fun updateUser(user_is: String, user: User) {
        val retroService  = RetroInstance.getRetroInstance().create(RetroServiceInterface::class.java)
        val call = retroService.updateUser(user_is, user)
        call.enqueue(object: Callback<UserResponse> {
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                createNewUserLiveData.postValue(null)
            }

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if(response.isSuccessful) {
                    createNewUserLiveData.postValue(response.body())
                } else {
                    createNewUserLiveData.postValue(null)
                }
            }
        })

    }
}