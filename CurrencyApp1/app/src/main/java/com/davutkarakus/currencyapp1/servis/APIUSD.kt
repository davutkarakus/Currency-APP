package com.davutkarakus.currencyapp1.servis

import com.davutkarakus.currencyapp1.model.baseUSDCurrencyModel
import io.reactivex.Single
import retrofit2.http.GET

interface APIUSD {
    @GET("latest?base=USD")
    fun getBaseUSDCurreny() :Single<baseUSDCurrencyModel>
}