package com.shiqiliu.movieapplication.data.respository.remote


import com.shiqiliu.movieapplication.data.respository.remote.ApiService.Companion.API_KEY
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    fun getApiClient(): Retrofit {
        //if use api key into interceptor
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor {
            chain ->
            val origin = chain.request()
            val requestBuilder = origin.url.newBuilder().addQueryParameter("api_key", API_KEY).build()
            val request = origin.newBuilder().url(requestBuilder).build()
            chain.proceed(request)
        }
        httpClient.addNetworkInterceptor(logging)

        //log http request and reponse data
//        val okHttpClient = OkHttpClient.Builder()
//            .addInterceptor(HttpLoggingInterceptor().apply {
//                level = HttpLoggingInterceptor.Level.BODY
//            })
//            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
          //  .create(MyApi::class.java)

        return retrofit
    }
    class ApiKeyInterceptor :Interceptor{
        override fun intercept(chain: Interceptor.Chain): Response {
            val request =chain.request()
            val httpUrl = request.url.newBuilder().addQueryParameter("api_key", API_KEY).build()
            val newRequst = chain.request().newBuilder().url(httpUrl).build()
            return chain.proceed(newRequst)
        }

    }

}