package com.davutkarakus.currencyapp1.view

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.davutkarakus.currencyapp1.R
import com.davutkarakus.currencyapp1.viewmodel.CurrencyViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel:CurrencyViewModel
    lateinit var birim:String
    lateinit var birim2:String
    lateinit var birim3:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.hide()
        viewModel=ViewModelProvider(this).get(CurrencyViewModel::class.java)
        val adapter= ArrayAdapter.createFromResource(this,R.array.currency_list,android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        firstSpinner.adapter=adapter
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        secondSpinner.adapter=adapter
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        thirdSpinner.adapter=adapter
        viewModel.refreshData()
        firstSpinner.onItemSelectedListener=object : AdapterView.OnItemSelectedListener
        {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                viewModel.refreshData()
                Toast.makeText(this@MainActivity,"Seçilen Eleman ${firstSpinner.adapter.getItem(position)}",
                    Toast.LENGTH_LONG)
                    .show()
                birim=firstSpinner.adapter.getItem(position).toString()
                observeLiveData(birim)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }


        convert1button.setOnClickListener {
            if (enterUSDeditText.text.isEmpty()) {
                val uyariMesaji = AlertDialog.Builder(this)
                uyariMesaji.setTitle("Hata")
                uyariMesaji.setMessage("Lütfen Değer/leri Giriniz")
                uyariMesaji.setPositiveButton(
                    "Tamam",
                    DialogInterface.OnClickListener { dialog, which ->
                        Toast.makeText(this, "Baştan Deniyorsunuz", Toast.LENGTH_LONG).show()

                    })

                uyariMesaji.show()
            }
            else{
                val deger1=enterUSDeditText.text.toString().toDouble()
                val deger2=tutucuText.text.toString().toDouble()
                sonucEditText1.text="${deger1} USD =${(deger1*deger2).toString() } ${birim}"
                tutucuText.text.isEmpty()


            }
        }
        secondSpinner.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                birim2=secondSpinner.adapter.getItem(position).toString()
                viewModel.refrestData1(birim2)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
        thirdSpinner.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                birim3=thirdSpinner.adapter.getItem(position).toString()
                observeLiveData1(birim3)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
        convert2Button.setOnClickListener {
            if (editText.text.isEmpty()) {
                val uyariMesaji = AlertDialog.Builder(this)
                uyariMesaji.setTitle("Hata")
                uyariMesaji.setMessage("Lütfen Değer/leri Giriniz")
                uyariMesaji.setPositiveButton(
                    "Tamam",
                    DialogInterface.OnClickListener { dialog, which ->
                        Toast.makeText(this, "Baştan Deniyorsunuz", Toast.LENGTH_LONG).show()

                    })

                uyariMesaji.show()
            }
            else{

                val deger1=editText.text.toString().toDouble()
                val deger2=tutucuText2.text.toString().toDouble()
                sonucEditText2.text="${deger1} ${birim2} =${(deger1*deger2).toString() } ${birim3}"
                tutucuText2.text.isEmpty()


            }
        }

    }
    fun observeLiveData(karsilastir:String){

        viewModel.bilgilerUSD.observe(this, Observer {
            it?.let {
                when(karsilastir){
                    "AED" -> tutucuText.text=(it.rates.aED)!!.toString()
                    "AFN" -> tutucuText.text=(it.rates.aFN)!!.toString()
                    "ALL" -> tutucuText.text=(it.rates.aLL)!!.toString()
                    "AMD" -> tutucuText.text=(it.rates.aMD)!!.toString()
                    "ANG" -> tutucuText.text=(it.rates.aNG)!!.toString()
                    "AOA" -> tutucuText.text=(it.rates.aOA)!!.toString()
                    "ARS" -> tutucuText.text=(it.rates.aRS)!!.toString()
                    "AUD" -> tutucuText.text=(it.rates.aUD)!!.toString()
                    "AWG"-> tutucuText.text=(it.rates.aWG)!!.toString()
                    "AZN"-> tutucuText.text=(it.rates.aZN)!!.toString()
                    "BAM"-> tutucuText.text=(it.rates.bAM)!!.toString()
                    "BBD"-> tutucuText.text=(it.rates.bBD)!!.toString()
                    "BDT"-> tutucuText.text=(it.rates.bDT)!!.toString()
                    "BGN"-> tutucuText.text=(it.rates.bGN)!!.toString()
                    "BHD"-> tutucuText.text=(it.rates.bHD)!!.toString()
                    "BIF"-> tutucuText.text=(it.rates.bIF)!!.toString()
                    "BMD"-> tutucuText.text=(it.rates.bMD)!!.toString()
                    "BND"-> tutucuText.text=(it.rates.bND)!!.toString()
                    "BOB"-> tutucuText.text=(it.rates.bOB)!!.toString()
                    "BRL"-> tutucuText.text=(it.rates.bRL)!!.toString()
                    "BSD"-> tutucuText.text=(it.rates.bSD)!!.toString()
                    "BTC"-> tutucuText.text=(it.rates.bTC)!!.toString()
                    "BTN"-> tutucuText.text=(it.rates.bTN)!!.toString()
                    "BWP"-> tutucuText.text=(it.rates.bWP)!!.toString()
                    "BYN"-> tutucuText.text=(it.rates.bYN)!!.toString()
                    "BZD"-> tutucuText.text=(it.rates.bZD)!!.toString()
                    "CAD"-> tutucuText.text=(it.rates.cAD)!!.toString()
                    "CDF"-> tutucuText.text=(it.rates.cDF)!!.toString()
                    "CHF"-> tutucuText.text=(it.rates.cHF)!!.toString()
                    "CLF"-> tutucuText.text=(it.rates.cLF)!!.toString()
                    "CLP"-> tutucuText.text=(it.rates.cLF)!!.toString()
                    "CNH"-> tutucuText.text=(it.rates.cNH)!!.toString()
                    "CNY"-> tutucuText.text=(it.rates.cNH)!!.toString()
                    "COP"-> tutucuText.text=(it.rates.cOP)!!.toString()
                    "CRC"-> tutucuText.text=(it.rates.cRC)!!.toString()
                    "CUC"-> tutucuText.text=(it.rates.cUC)!!.toString()
                    "CUP"-> tutucuText.text=(it.rates.cUP)!!.toString()
                    "CVE"-> tutucuText.text=(it.rates.cVE)!!.toString()
                    "CZK"-> tutucuText.text=(it.rates.cZK)!!.toString()
                    "DJF"-> tutucuText.text=(it.rates.dJF)!!.toString()
                    "DKK"-> tutucuText.text=(it.rates.dKK)!!.toString()
                    "DOP"-> tutucuText.text=(it.rates.dOP)!!.toString()
                    "DZD"-> tutucuText.text=(it.rates.dZD)!!.toString()
                    "EGP"-> tutucuText.text=(it.rates.eGP)!!.toString()
                    "ERN"-> tutucuText.text=(it.rates.eRN)!!.toString()
                    "ETB"-> tutucuText.text=(it.rates.eTB)!!.toString()
                    "EUR"-> tutucuText.text=(it.rates.eUR)!!.toString()
                    "FJD"-> tutucuText.text=(it.rates.fJD)!!.toString()
                    "FKP"-> tutucuText.text=(it.rates.fKP)!!.toString()
                    "GBP"-> tutucuText.text=(it.rates.gBP)!!.toString()
                    "GEL"-> tutucuText.text=(it.rates.gEL)!!.toString()
                    "GGP"-> tutucuText.text=(it.rates.gGP)!!.toString()
                    "GHS"-> tutucuText.text=(it.rates.gHS)!!.toString()
                    "GIP"-> tutucuText.text=(it.rates.gIP)!!.toString()
                    "GMD"-> tutucuText.text=(it.rates.gMD)!!.toString()
                    "GNF"-> tutucuText.text=(it.rates.gNF)!!.toString()
                    "GTQ"-> tutucuText.text=(it.rates.gTQ)!!.toString()
                    "GYD"-> tutucuText.text=(it.rates.gYD)!!.toString()
                    "HKD"-> tutucuText.text=(it.rates.hKD)!!.toString()
                    "HNL"-> tutucuText.text=(it.rates.hNL)!!.toString()
                    "HRK"-> tutucuText.text=(it.rates.hRK)!!.toString()
                    "HTG"-> tutucuText.text=(it.rates.hTG)!!.toString()
                    "HUF"-> tutucuText.text=(it.rates.hUF)!!.toString()
                    "IDR"-> tutucuText.text=(it.rates.iDR)!!.toString()
                    "ILS"-> tutucuText.text=(it.rates.iLS)!!.toString()
                    "IMP"-> tutucuText.text=(it.rates.iMP)!!.toString()
                    "INR"-> tutucuText.text=(it.rates.iNR)!!.toString()
                    "IQD"-> tutucuText.text=(it.rates.iQD)!!.toString()
                    "IRR"-> tutucuText.text=(it.rates.iRR)!!.toString()
                    "ISK"-> tutucuText.text=(it.rates.iSK)!!.toString()
                    "JEP"-> tutucuText.text=(it.rates.jEP)!!.toString()
                    "JMD"-> tutucuText.text=(it.rates.jMD)!!.toString()
                    "JOD"-> tutucuText.text=(it.rates.jOD)!!.toString()
                    "JPY"-> tutucuText.text=(it.rates.jPY)!!.toString()
                    "KES"-> tutucuText.text=(it.rates.kES)!!.toString()
                    "KGS"-> tutucuText.text=(it.rates.kGS)!!.toString()
                    "KHR"-> tutucuText.text=(it.rates.kHR)!!.toString()
                    "KMF"-> tutucuText.text=(it.rates.kMF)!!.toString()
                    "KPW"-> tutucuText.text=(it.rates.kPW)!!.toString()
                    "KRW"-> tutucuText.text=(it.rates.kRW)!!.toString()
                    "KWD"-> tutucuText.text=(it.rates.kWD)!!.toString()
                    "KYD"-> tutucuText.text=(it.rates.kYD)!!.toString()
                    "KZT"-> tutucuText.text=(it.rates.kZT)!!.toString()
                    "LAK"-> tutucuText.text=(it.rates.lAK)!!.toString()
                    "LBP"-> tutucuText.text=(it.rates.lBP)!!.toString()
                    "LKR"-> tutucuText.text=(it.rates.lKR)!!.toString()
                    "LRD"-> tutucuText.text=(it.rates.lRD)!!.toString()
                    "LSL"-> tutucuText.text=(it.rates.lSL)!!.toString()
                    "LYD"-> tutucuText.text=(it.rates.lYD)!!.toString()
                    "MAD"-> tutucuText.text=(it.rates.mAD)!!.toString()
                    "MDL"-> tutucuText.text=(it.rates.mDL)!!.toString()
                    "MGA"-> tutucuText.text=(it.rates.mGA)!!.toString()
                    "MKD"-> tutucuText.text=(it.rates.mKD)!!.toString()
                    "MMK"-> tutucuText.text=(it.rates.mMK)!!.toString()
                    "MNT"-> tutucuText.text=(it.rates.mNT)!!.toString()
                    "MOP"-> tutucuText.text=(it.rates.mOP)!!.toString()
                    "MRU"-> tutucuText.text=(it.rates.mRU)!!.toString()
                    "MUR"-> tutucuText.text=(it.rates.mUR)!!.toString()
                    "MVR"-> tutucuText.text=(it.rates.mVR)!!.toString()
                    "MWK"-> tutucuText.text=(it.rates.mWK)!!.toString()
                    "MXN"-> tutucuText.text=(it.rates.mXN)!!.toString()
                    "MYR"-> tutucuText.text=(it.rates.mYR)!!.toString()
                    "MZN"-> tutucuText.text=(it.rates.mZN)!!.toString()
                    "NAD"-> tutucuText.text=(it.rates.nAD)!!.toString()
                    "NGN"-> tutucuText.text=(it.rates.nGN)!!.toString()
                    "NIO"-> tutucuText.text=(it.rates.nIO)!!.toString()
                    "NOK"-> tutucuText.text=(it.rates.nOK)!!.toString()
                    "NPR"-> tutucuText.text=(it.rates.nPR)!!.toString()
                    "NZD"-> tutucuText.text=(it.rates.nZD)!!.toString()
                    "OMR"-> tutucuText.text=(it.rates.oMR)!!.toString()
                    "PAB"-> tutucuText.text=(it.rates.pAB)!!.toString()
                    "PEN"-> tutucuText.text=(it.rates.pEN)!!.toString()
                    "PGK"-> tutucuText.text=(it.rates.pGK)!!.toString()
                    "PHP"-> tutucuText.text=(it.rates.pHP)!!.toString()
                    "PKR"-> tutucuText.text=(it.rates.pKR)!!.toString()
                    "PLN"-> tutucuText.text=(it.rates.pLN)!!.toString()
                    "PYG"-> tutucuText.text=(it.rates.pYG)!!.toString()
                    "QAR"-> tutucuText.text=(it.rates.qAR)!!.toString()
                    "RON"-> tutucuText.text=(it.rates.rON)!!.toString()
                    "RSD"-> tutucuText.text=(it.rates.rSD)!!.toString()
                    "RUB"-> tutucuText.text=(it.rates.rUB)!!.toString()
                    "RWF"-> tutucuText.text=(it.rates.rWF)!!.toString()
                    "SAR"-> tutucuText.text=(it.rates.sAR)!!.toString()
                    "SBD"-> tutucuText.text=(it.rates.sBD)!!.toString()
                    "SCR"-> tutucuText.text=(it.rates.sCR)!!.toString()
                    "SDG"-> tutucuText.text=(it.rates.sDG)!!.toString()
                    "SEK"-> tutucuText.text=(it.rates.sEK)!!.toString()
                    "SGD"-> tutucuText.text=(it.rates.sGD)!!.toString()
                    "SHP"-> tutucuText.text=(it.rates.sHP)!!.toString()
                    "SLL"-> tutucuText.text=(it.rates.sLL)!!.toString()
                    "SOS"-> tutucuText.text=(it.rates.sOS)!!.toString()
                    "SRD"-> tutucuText.text=(it.rates.sRD)!!.toString()
                    "SSP"-> tutucuText.text=(it.rates.sSP)!!.toString()
                    "STD"-> tutucuText.text=(it.rates.sTD)!!.toString()
                    "STN"-> tutucuText.text=(it.rates.sTN)!!.toString()
                    "SVC"-> tutucuText.text=(it.rates.sVC)!!.toString()
                    "SYP"-> tutucuText.text=(it.rates.sYP)!!.toString()
                    "SZL"-> tutucuText.text=(it.rates.sZL)!!.toString()
                    "THB"-> tutucuText.text=(it.rates.tHB)!!.toString()
                    "TJS"-> tutucuText.text=(it.rates.tJS)!!.toString()
                    "TMT"-> tutucuText.text=(it.rates.tMT)!!.toString()
                    "TND"-> tutucuText.text=(it.rates.tND)!!.toString()
                    "TOP"-> tutucuText.text=(it.rates.tOP)!!.toString()
                    "TRY"-> tutucuText.text=(it.rates.tRY)!!.toString()
                    "TTD"-> tutucuText.text=(it.rates.tTD)!!.toString()
                    "TWD"-> tutucuText.text=(it.rates.tWD)!!.toString()
                    "TZS"-> tutucuText.text=(it.rates.tZS)!!.toString()
                    "UAH"-> tutucuText.text=(it.rates.uAH)!!.toString()
                    "UGX"-> tutucuText.text=(it.rates.uGX)!!.toString()
                    "USD"-> tutucuText.text=(it.rates.uSD)!!.toString()
                    "UYU"-> tutucuText.text=(it.rates.uYU)!!.toString()
                    "UZS"-> tutucuText.text=(it.rates.uZS)!!.toString()
                    "VES"-> tutucuText.text=(it.rates.vES)!!.toString()
                    "VND"-> tutucuText.text=(it.rates.vND)!!.toString()
                    "VUV"-> tutucuText.text=(it.rates.vUV)!!.toString()
                    "WST"-> tutucuText.text=(it.rates.wST)!!.toString()
                    "XAF"-> tutucuText.text=(it.rates.xAF)!!.toString()
                    "XAG"-> tutucuText.text=(it.rates.xAG)!!.toString()
                    "XAU"-> tutucuText.text=(it.rates.xAU)!!.toString()
                    "XCD"-> tutucuText.text=(it.rates.xCD)!!.toString()
                    "XDR"-> tutucuText.text=(it.rates.xDR)!!.toString()
                    "XOF"-> tutucuText.text=(it.rates.xOF)!!.toString()
                    "XPD"-> tutucuText.text=(it.rates.xPD)!!.toString()
                    "XPF"-> tutucuText.text=(it.rates.xPF)!!.toString()
                    "XPT"-> tutucuText.text=(it.rates.xPT)!!.toString()
                    "YER"-> tutucuText.text=(it.rates.yER)!!.toString()
                    "ZAR"-> tutucuText.text=(it.rates.zAR)!!.toString()
                    "ZMW"-> tutucuText.text=(it.rates.zMW)!!.toString()
                    "ZWL"-> tutucuText.text=(it.rates.zWL)!!.toString()
                }
            }
        })
       hataMesajiandYukleniyor()
    }
    fun observeLiveData1(karsilastir:String){

        viewModel.bilgilerAnyCurrency.observe(this, Observer {
            it?.let {
                when(karsilastir){
                    "AED" -> tutucuText2.text=(it.rates.aED)!!.toString()
                    "AFN" -> tutucuText2.text=(it.rates.aFN)!!.toString()
                    "ALL" -> tutucuText2.text=(it.rates.aLL)!!.toString()
                    "AMD" -> tutucuText2.text=(it.rates.aMD)!!.toString()
                    "ANG" -> tutucuText2.text=(it.rates.aNG)!!.toString()
                    "AOA" -> tutucuText2.text=(it.rates.aOA)!!.toString()
                    "ARS" -> tutucuText2.text=(it.rates.aRS)!!.toString()
                    "AUD" -> tutucuText2.text=(it.rates.aUD)!!.toString()
                    "AWG"-> tutucuText2.text=(it.rates.aWG)!!.toString()
                    "AZN"-> tutucuText2.text=(it.rates.aZN)!!.toString()
                    "BAM"-> tutucuText2.text=(it.rates.bAM)!!.toString()
                    "BBD"-> tutucuText2.text=(it.rates.bBD)!!.toString()
                    "BDT"-> tutucuText2.text=(it.rates.bDT)!!.toString()
                    "BGN"-> tutucuText2.text=(it.rates.bGN)!!.toString()
                    "BHD"-> tutucuText2.text=(it.rates.bHD)!!.toString()
                    "BIF"-> tutucuText2.text=(it.rates.bIF)!!.toString()
                    "BMD"-> tutucuText2.text=(it.rates.bMD)!!.toString()
                    "BND"-> tutucuText2.text=(it.rates.bND)!!.toString()
                    "BOB"-> tutucuText2.text=(it.rates.bOB)!!.toString()
                    "BRL"-> tutucuText2.text=(it.rates.bRL)!!.toString()
                    "BSD"-> tutucuText2.text=(it.rates.bSD)!!.toString()
                    "BTC"-> tutucuText2.text=(it.rates.bTC)!!.toString()
                    "BTN"-> tutucuText2.text=(it.rates.bTN)!!.toString()
                    "BWP"-> tutucuText2.text=(it.rates.bWP)!!.toString()
                    "BYN"-> tutucuText2.text=(it.rates.bYN)!!.toString()
                    "BZD"-> tutucuText2.text=(it.rates.bZD)!!.toString()
                    "CAD"-> tutucuText2.text=(it.rates.cAD)!!.toString()
                    "CDF"-> tutucuText2.text=(it.rates.cDF)!!.toString()
                    "CHF"-> tutucuText2.text=(it.rates.cHF)!!.toString()
                    "CLF"-> tutucuText2.text=(it.rates.cLF)!!.toString()
                    "CLP"-> tutucuText2.text=(it.rates.cLF)!!.toString()
                    "CNH"-> tutucuText2.text=(it.rates.cNH)!!.toString()
                    "CNY"-> tutucuText2.text=(it.rates.cNH)!!.toString()
                    "COP"-> tutucuText2.text=(it.rates.cOP)!!.toString()
                    "CRC"-> tutucuText2.text=(it.rates.cRC)!!.toString()
                    "CUC"-> tutucuText2.text=(it.rates.cUC)!!.toString()
                    "CUP"-> tutucuText2.text=(it.rates.cUP)!!.toString()
                    "CVE"-> tutucuText2.text=(it.rates.cVE)!!.toString()
                    "CZK"-> tutucuText2.text=(it.rates.cZK)!!.toString()
                    "DJF"-> tutucuText2.text=(it.rates.dJF)!!.toString()
                    "DKK"-> tutucuText2.text=(it.rates.dKK)!!.toString()
                    "DOP"-> tutucuText2.text=(it.rates.dOP)!!.toString()
                    "DZD"-> tutucuText2.text=(it.rates.dZD)!!.toString()
                    "EGP"-> tutucuText2.text=(it.rates.eGP)!!.toString()
                    "ERN"-> tutucuText2.text=(it.rates.eRN)!!.toString()
                    "ETB"-> tutucuText2.text=(it.rates.eTB)!!.toString()
                    "EUR"-> tutucuText2.text=(it.rates.eUR)!!.toString()
                    "FJD"-> tutucuText2.text=(it.rates.fJD)!!.toString()
                    "FKP"-> tutucuText2.text=(it.rates.fKP)!!.toString()
                    "GBP"-> tutucuText2.text=(it.rates.gBP)!!.toString()
                    "GEL"-> tutucuText2.text=(it.rates.gEL)!!.toString()
                    "GGP"-> tutucuText2.text=(it.rates.gGP)!!.toString()
                    "GHS"-> tutucuText2.text=(it.rates.gHS)!!.toString()
                    "GIP"-> tutucuText2.text=(it.rates.gIP)!!.toString()
                    "GMD"-> tutucuText2.text=(it.rates.gMD)!!.toString()
                    "GNF"-> tutucuText2.text=(it.rates.gNF)!!.toString()
                    "GTQ"-> tutucuText2.text=(it.rates.gTQ)!!.toString()
                    "GYD"-> tutucuText2.text=(it.rates.gYD)!!.toString()
                    "HKD"-> tutucuText2.text=(it.rates.hKD)!!.toString()
                    "HNL"-> tutucuText2.text=(it.rates.hNL)!!.toString()
                    "HRK"-> tutucuText2.text=(it.rates.hRK)!!.toString()
                    "HTG"-> tutucuText2.text=(it.rates.hTG)!!.toString()
                    "HUF"-> tutucuText2.text=(it.rates.hUF)!!.toString()
                    "IDR"-> tutucuText2.text=(it.rates.iDR)!!.toString()
                    "ILS"-> tutucuText2.text=(it.rates.iLS)!!.toString()
                    "IMP"-> tutucuText2.text=(it.rates.iMP)!!.toString()
                    "INR"-> tutucuText2.text=(it.rates.iNR)!!.toString()
                    "IQD"-> tutucuText2.text=(it.rates.iQD)!!.toString()
                    "IRR"-> tutucuText2.text=(it.rates.iRR)!!.toString()
                    "ISK"-> tutucuText2.text=(it.rates.iSK)!!.toString()
                    "JEP"-> tutucuText2.text=(it.rates.jEP)!!.toString()
                    "JMD"-> tutucuText2.text=(it.rates.jMD)!!.toString()
                    "JOD"-> tutucuText2.text=(it.rates.jOD)!!.toString()
                    "JPY"-> tutucuText2.text=(it.rates.jPY)!!.toString()
                    "KES"-> tutucuText2.text=(it.rates.kES)!!.toString()
                    "KGS"-> tutucuText2.text=(it.rates.kGS)!!.toString()
                    "KHR"-> tutucuText2.text=(it.rates.kHR)!!.toString()
                    "KMF"-> tutucuText2.text=(it.rates.kMF)!!.toString()
                    "KPW"-> tutucuText2.text=(it.rates.kPW)!!.toString()
                    "KRW"-> tutucuText2.text=(it.rates.kRW)!!.toString()
                    "KWD"-> tutucuText2.text=(it.rates.kWD)!!.toString()
                    "KYD"-> tutucuText2.text=(it.rates.kYD)!!.toString()
                    "KZT"-> tutucuText2.text=(it.rates.kZT)!!.toString()
                    "LAK"-> tutucuText2.text=(it.rates.lAK)!!.toString()
                    "LBP"-> tutucuText2.text=(it.rates.lBP)!!.toString()
                    "LKR"-> tutucuText2.text=(it.rates.lKR)!!.toString()
                    "LRD"-> tutucuText2.text=(it.rates.lRD)!!.toString()
                    "LSL"-> tutucuText2.text=(it.rates.lSL)!!.toString()
                    "LYD"-> tutucuText2.text=(it.rates.lYD)!!.toString()
                    "MAD"-> tutucuText2.text=(it.rates.mAD)!!.toString()
                    "MDL"-> tutucuText2.text=(it.rates.mDL)!!.toString()
                    "MGA"-> tutucuText2.text=(it.rates.mGA)!!.toString()
                    "MKD"-> tutucuText2.text=(it.rates.mKD)!!.toString()
                    "MMK"-> tutucuText2.text=(it.rates.mMK)!!.toString()
                    "MNT"-> tutucuText2.text=(it.rates.mNT)!!.toString()
                    "MOP"-> tutucuText2.text=(it.rates.mOP)!!.toString()
                    "MRU"-> tutucuText2.text=(it.rates.mRU)!!.toString()
                    "MUR"-> tutucuText2.text=(it.rates.mUR)!!.toString()
                    "MVR"-> tutucuText2.text=(it.rates.mVR)!!.toString()
                    "MWK"-> tutucuText2.text=(it.rates.mWK)!!.toString()
                    "MXN"-> tutucuText2.text=(it.rates.mXN)!!.toString()
                    "MYR"-> tutucuText2.text=(it.rates.mYR)!!.toString()
                    "MZN"-> tutucuText2.text=(it.rates.mZN)!!.toString()
                    "NAD"-> tutucuText2.text=(it.rates.nAD)!!.toString()
                    "NGN"-> tutucuText2.text=(it.rates.nGN)!!.toString()
                    "NIO"-> tutucuText2.text=(it.rates.nIO)!!.toString()
                    "NOK"-> tutucuText2.text=(it.rates.nOK)!!.toString()
                    "NPR"-> tutucuText2.text=(it.rates.nPR)!!.toString()
                    "NZD"-> tutucuText2.text=(it.rates.nZD)!!.toString()
                    "OMR"-> tutucuText2.text=(it.rates.oMR)!!.toString()
                    "PAB"-> tutucuText2.text=(it.rates.pAB)!!.toString()
                    "PEN"-> tutucuText2.text=(it.rates.pEN)!!.toString()
                    "PGK"-> tutucuText2.text=(it.rates.pGK)!!.toString()
                    "PHP"-> tutucuText2.text=(it.rates.pHP)!!.toString()
                    "PKR"-> tutucuText2.text=(it.rates.pKR)!!.toString()
                    "PLN"-> tutucuText2.text=(it.rates.pLN)!!.toString()
                    "PYG"-> tutucuText2.text=(it.rates.pYG)!!.toString()
                    "QAR"-> tutucuText2.text=(it.rates.qAR)!!.toString()
                    "RON"-> tutucuText2.text=(it.rates.rON)!!.toString()
                    "RSD"-> tutucuText2.text=(it.rates.rSD)!!.toString()
                    "RUB"-> tutucuText2.text=(it.rates.rUB)!!.toString()
                    "RWF"-> tutucuText2.text=(it.rates.rWF)!!.toString()
                    "SAR"-> tutucuText2.text=(it.rates.sAR)!!.toString()
                    "SBD"-> tutucuText2.text=(it.rates.sBD)!!.toString()
                    "SCR"-> tutucuText2.text=(it.rates.sCR)!!.toString()
                    "SDG"-> tutucuText2.text=(it.rates.sDG)!!.toString()
                    "SEK"-> tutucuText2.text=(it.rates.sEK)!!.toString()
                    "SGD"-> tutucuText2.text=(it.rates.sGD)!!.toString()
                    "SHP"-> tutucuText2.text=(it.rates.sHP)!!.toString()
                    "SLL"-> tutucuText2.text=(it.rates.sLL)!!.toString()
                    "SOS"-> tutucuText2.text=(it.rates.sOS)!!.toString()
                    "SRD"-> tutucuText2.text=(it.rates.sRD)!!.toString()
                    "SSP"-> tutucuText2.text=(it.rates.sSP)!!.toString()
                    "STD"-> tutucuText2.text=(it.rates.sTD)!!.toString()
                    "STN"-> tutucuText2.text=(it.rates.sTN)!!.toString()
                    "SVC"-> tutucuText2.text=(it.rates.sVC)!!.toString()
                    "SYP"-> tutucuText2.text=(it.rates.sYP)!!.toString()
                    "SZL"-> tutucuText2.text=(it.rates.sZL)!!.toString()
                    "THB"-> tutucuText2.text=(it.rates.tHB)!!.toString()
                    "TJS"-> tutucuText2.text=(it.rates.tJS)!!.toString()
                    "TMT"-> tutucuText2.text=(it.rates.tMT)!!.toString()
                    "TND"-> tutucuText2.text=(it.rates.tND)!!.toString()
                    "TOP"-> tutucuText2.text=(it.rates.tOP)!!.toString()
                    "TRY"-> tutucuText2.text=(it.rates.tRY)!!.toString()
                    "TTD"-> tutucuText2.text=(it.rates.tTD)!!.toString()
                    "TWD"-> tutucuText2.text=(it.rates.tWD)!!.toString()
                    "TZS"-> tutucuText2.text=(it.rates.tZS)!!.toString()
                    "UAH"-> tutucuText2.text=(it.rates.uAH)!!.toString()
                    "UGX"-> tutucuText2.text=(it.rates.uGX)!!.toString()
                    "USD"-> tutucuText2.text=(it.rates.uSD)!!.toString()
                    "UYU"-> tutucuText2.text=(it.rates.uYU)!!.toString()
                    "UZS"-> tutucuText2.text=(it.rates.uZS)!!.toString()
                    "VES"-> tutucuText2.text=(it.rates.vES)!!.toString()
                    "VND"-> tutucuText2.text=(it.rates.vND)!!.toString()
                    "VUV"-> tutucuText2.text=(it.rates.vUV)!!.toString()
                    "WST"-> tutucuText2.text=(it.rates.wST)!!.toString()
                    "XAF"-> tutucuText2.text=(it.rates.xAF)!!.toString()
                    "XAG"-> tutucuText2.text=(it.rates.xAG)!!.toString()
                    "XAU"-> tutucuText2.text=(it.rates.xAU)!!.toString()
                    "XCD"-> tutucuText2.text=(it.rates.xCD)!!.toString()
                    "XDR"-> tutucuText2.text=(it.rates.xDR)!!.toString()
                    "XOF"-> tutucuText2.text=(it.rates.xOF)!!.toString()
                    "XPD"-> tutucuText2.text=(it.rates.xPD)!!.toString()
                    "XPF"-> tutucuText2.text=(it.rates.xPF)!!.toString()
                    "XPT"-> tutucuText2.text=(it.rates.xPT)!!.toString()
                    "YER"-> tutucuText2.text=(it.rates.yER)!!.toString()
                    "ZAR"-> tutucuText2.text=(it.rates.zAR)!!.toString()
                    "ZMW"-> tutucuText2.text=(it.rates.zMW)!!.toString()
                    "ZWL"-> tutucuText2.text=(it.rates.zWL)!!.toString()
                }
            }
        })
        hataMesajiandYukleniyor()
    }

    fun hataMesajiandYukleniyor(){
        viewModel.hataMesaji.observe(this, Observer {
            it?.let {
                if(it){
                    hataMesajiTextView.visibility=View.VISIBLE
                }
                else{
                    hataMesajiTextView.visibility=View.GONE
                }
            }
        })
        viewModel.yukleniyor.observe(this, Observer {
            it?.let {
                if(it){
                    hataMesajiTextView.visibility=View.GONE
                    progressBar2.visibility=View.VISIBLE
                }
                else{
                    progressBar2.visibility=View.GONE
                }
            }
        })
    }

}