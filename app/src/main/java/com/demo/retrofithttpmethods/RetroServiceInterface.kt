package com.demo.retrofithttpmethods

import retrofit2.Call
import retrofit2.http.*

interface RetroServiceInterface {

    @POST("users")
    @Headers("Accept:application/json", "Content-Type:application/json",
    "Authorization: Bearer 73668350bdf06c66f3388408c1a712b378c3e25da599753b21b664a6261e246c")
    fun createUser(@Body params: User): Call<UserResponse>

    @GET("users/{user_id}")
    @Headers("Accept:application/json", "Content-Type:application/json",
        "Authorization: Bearer 73668350bdf06c66f3388408c1a712b378c3e25da599753b21b664a6261e246c")
    fun getUser(@Path("user_id") user_id: String): Call<UserResponse>

    @PATCH("users/{user_id}")
    @Headers("Accept:application/json", "Content-Type:application/json",
        "Authorization: Bearer 73668350bdf06c66f3388408c1a712b378c3e25da599753b21b664a6261e246c")
    fun updateUser(@Path("user_id")user_id: String, @Body params: User): Call<UserResponse>
}