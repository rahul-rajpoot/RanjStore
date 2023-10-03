package com.alps.ranjstore.com.alps.ranjstore.net

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor: Interceptor {
   // override fun intercept(chain: Interceptor.Chain): Response {
      //  lateinit var tokenManager: TokenManager
      /*  val token = tokenManager.getToken()
        request.addHeader("Authorization", "Bearer $token")
        return chain.proceed(request.build())*/

    //  return chain.proceed(request.build)
    // }
    override fun intercept(chain: Interceptor.Chain): Response {
        TODO("Not yet implemented")
    }
}