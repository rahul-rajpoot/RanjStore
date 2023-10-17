package com.alps.ranjstore.net


import com.alps.ranjstore.model.ProfileDetails
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {
    @GET("getProfile/M/RS298HySRanj/1/SC58RANJS4542CRRE/ranjstore/12345")
     fun getProfile(): Call<ProfileDetails>

    @GET("UserAuthentication/M/RS298HySRanj/1/SC58RANJS4542CRRE/ranjstore/12345548")
    fun getLogin(): Call<ProfileDetails>

    //https://api.ranjstore.com/DeveloperAPI/UserAuthentication/M/RS298HySRanj/1/SC58RANJS4542CRRE/ranjstore/12345548
}