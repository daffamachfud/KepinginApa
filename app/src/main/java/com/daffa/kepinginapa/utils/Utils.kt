package com.daffa.kepinginapa.utils

import android.graphics.drawable.Drawable
import com.daffa.kepinginapa.R
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

object Utils {
    fun getCategoryIcon(category:String):Int{
        when(category){
            else->{
             return R.drawable.ic_error_img
            }
        }
    }

    fun Double.formatCurrencyRupiah():String{
        val formatter = DecimalFormat("###,###,###.##")
        val formatRp = DecimalFormatSymbols()
        formatRp.groupingSeparator = '.'
        formatRp.decimalSeparator = ','
        formatter.decimalFormatSymbols = formatRp
        return "Rp. " + formatter.format(this)
    }
}