package com.davutkarakus.currencyapp1.servis

import com.davutkarakus.currencyapp1.model.baseUSDCurrencyModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiServis {
    val BASE_URL="https://api.exchangerate.host/"
    val api= Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(APIUSD::class.java)


    fun getBaseUsdData() :Single<baseUSDCurrencyModel>{
        return api.getBaseUSDCurreny()
    }
}