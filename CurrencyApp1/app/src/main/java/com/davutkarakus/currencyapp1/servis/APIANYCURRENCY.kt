package com.davutkarakus.currencyapp1.servis

import com.davutkarakus.currencyapp1.model.baseAnyCurrencyModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface APIANYCURRENCY {
    @GET("latest?")
    fun getAnyCurrencyBilgi(@Query("base") baseName:String) :Single<baseAnyCurrencyModel>
}