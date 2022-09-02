package com.davutkarakus.currencyapp1.model


import com.google.gson.annotations.SerializedName

data class baseAnyCurrencyModel(
    @SerializedName("base")
    val base: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("motd")
    val motd: MotdX,
    @SerializedName("rates")
    val rates: RatesX,
    @SerializedName("success")
    val success: Boolean
)