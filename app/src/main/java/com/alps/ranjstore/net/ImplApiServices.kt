package com.alps.ranjstore.com.alps.ranjstore.net

import com.alps.ranjstore.model.ProfileDetails
import com.alps.ranjstore.net.ApiServices
import retrofit2.Call

class ImplApiServices :ApiServices{
    override fun getProfile(): Call<ProfileDetails> {
        TODO("Not yet implemented")
    }

    override fun getLogin(): Call<ProfileDetails> {
        TODO("Not yet implemented")
    }
}