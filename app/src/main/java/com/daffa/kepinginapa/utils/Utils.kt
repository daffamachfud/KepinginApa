package com.daffa.kepinginapa.utils

import android.content.ContentUris
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import java.lang.ref.WeakReference
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.util.*


object Utils {
//    fun getCategoryIcon(category: String?): Int {
//        when (category) {
//            else -> {
//                return R.drawable.ic_error_img
//            }
//        }
//    }

    fun Double?.formatCurrencyRupiah(): String {
        val formatter = DecimalFormat("###,###,###.##")
        val formatRp = DecimalFormatSymbols()
        formatRp.groupingSeparator = '.'
        formatRp.decimalSeparator = ','
        formatter.decimalFormatSymbols = formatRp
        return "Rp. " + formatter.format(this)
    }

    class UriPathHelper {
        fun getPath(context: Context, uri: Uri): String? {
            val isKitKatorAbove = true

            // DocumentProvider
            if (isKitKatorAbove && DocumentsContract.isDocumentUri(context, uri)) {
                // ExternalStorageProvider
                if (isExternalStorageDocument(uri)) {
                    val docId = DocumentsContract.getDocumentId(uri)
                    val split = docId.split(":".toRegex()).toTypedArray()
                    val type = split[0]
                    if ("primary".equals(type, ignoreCase = true)) {
                        return Environment.getExternalStorageDirectory().toString() + "/" + split[1]
                    }

                } else if (isDownloadsDocument(uri)) {
                    val id = DocumentsContract.getDocumentId(uri)
                    val contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"),
                        java.lang.Long.valueOf(id)
                    )
                    return getDataColumn(context, contentUri, null, null)
                } else if (isMediaDocument(uri)) {
                    val docId = DocumentsContract.getDocumentId(uri)
                    val split = docId.split(":".toRegex()).toTypedArray()
                    val type = split[0]
                    var contentUri: Uri? = null
                    when (type) {
                        "image" -> {
                            contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                        }
                        "video" -> {
                            contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI
                        }
                        "audio" -> {
                            contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
                        }
                    }
                    val selection = "_id=?"
                    val selectionArgs = arrayOf(split[1])
                    return getDataColumn(context, contentUri, selection, selectionArgs)
                }
            } else if ("content".equals(uri.scheme, ignoreCase = true)) {
                return getDataColumn(context, uri, null, null)
            } else if ("file".equals(uri.scheme, ignoreCase = true)) {
                return uri.path
            }
            return null
        }

        private fun getDataColumn(
            context: Context,
            uri: Uri?,
            selection: String?,
            selectionArgs: Array<String>?
        ): String? {
            var cursor: Cursor? = null
            val column = "_data"
            val projection = arrayOf(column)
            try {
                cursor = uri?.let {
                    context.contentResolver.query(
                        it,
                        projection,
                        selection,
                        selectionArgs,
                        null
                    )
                }
                if (cursor != null && cursor.moveToFirst()) {
                    val columnIndex: Int = cursor.getColumnIndexOrThrow(column)
                    return cursor.getString(columnIndex)
                }
            } finally {
                cursor?.close()
            }
            return null
        }

        private fun isExternalStorageDocument(uri: Uri): Boolean {
            return "com.android.externalstorage.documents" == uri.authority
        }

        private fun isDownloadsDocument(uri: Uri): Boolean {
            return "com.android.providers.downloads.documents" == uri.authority
        }

        private fun isMediaDocument(uri: Uri): Boolean {
            return "com.android.providers.media.documents" == uri.authority
        }
    }

    class MoneyTextWatcher(editText: EditText?) : TextWatcher {
        private val editTextWeakReference: WeakReference<EditText> = WeakReference(editText)
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable) {
            val editText: EditText? = editTextWeakReference.get()
            if (editText == null || editText.text.toString() == "") {
                return
            }
            editText.removeTextChangedListener(this)
            val parsed: BigDecimal = parseCurrencyValue(editText.text.toString())
            val formatted: String = numberFormat.format(parsed)
            editText.setText(formatted)
            editText.setSelection(formatted.length)
            editText.addTextChangedListener(this)
        }

        companion object {
            val numberFormat: NumberFormat = NumberFormat.getCurrencyInstance(Locale("id", "ID"))
            fun parseCurrencyValue(value: String): BigDecimal {
                try {
                    val replaceRegex = java.lang.String.format(
                        "[%s,.\\s]", Objects.requireNonNull(
                            numberFormat.currency
                        ).displayName
                    )
                    val currencyValue = value.replace(replaceRegex.toRegex(), "")
                    return BigDecimal(currencyValue)
                } catch (e: Exception) {
                    Log.e("Error", e.message, e)
                }
                return BigDecimal.ZERO
            }
        }

        init {
            numberFormat.maximumFractionDigits = 0
            numberFormat.roundingMode = RoundingMode.FLOOR
        }
    }
}