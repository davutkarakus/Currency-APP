package com.davutkarakus.currencyapp1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.davutkarakus.currencyapp1.model.baseAnyCurrencyModel
import com.davutkarakus.currencyapp1.model.baseUSDCurrencyModel
import com.davutkarakus.currencyapp1.servis.ApiServis
import com.davutkarakus.currencyapp1.servis.ApiServisAny
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class CurrencyViewModel:ViewModel() {
    val bilgilerUSD=MutableLiveData<baseUSDCurrencyModel>()
    val bilgilerAnyCurrency=MutableLiveData<baseAnyCurrencyModel>()
    val hataMesaji=MutableLiveData<Boolean>()
    val yukleniyor=MutableLiveData<Boolean>()
    val disposable=CompositeDisposable()
    private val apiServis=ApiServis()
    private val apiServis1=ApiServisAny()
    fun refreshData(){
        yukleniyor.value=true
        hataMesaji.value=false
        disposable.add(
            apiServis.getBaseUsdData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :DisposableSingleObserver<baseUSDCurrencyModel>(){
                    override fun onSuccess(t: baseUSDCurrencyModel) {
                        bilgilerUSD.value=t
                        yukleniyor.value=false
                        hataMesaji.value=false
                    }

                    override fun onError(e: Throwable) {
                        yukleniyor.value=false
                        hataMesaji.value=true
                    }

                })
        )
    }
    fun refrestData1(baseName:String){
        yukleniyor.value=true
        hataMesaji.value=false
        disposable.add(
            apiServis1.getData(baseName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :DisposableSingleObserver<baseAnyCurrencyModel>(){
                    override fun onSuccess(t: baseAnyCurrencyModel) {
                        bilgilerAnyCurrency.value=t
                        yukleniyor.value=false
                        hataMesaji.value=false
                    }

                    override fun onError(e: Throwable) {
                        yukleniyor.value=false
                        hataMesaji.value=true
                    }

                })
        )
    }
}