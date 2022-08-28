package com.daffa.kepinginapa.utils

import android.content.ContentUris
import android.content.Context
import android.database.Cursor
import android.graphics.Rect
import android.net.Uri
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import nl.dionsegijn.konfetti.core.*
import nl.dionsegijn.konfetti.core.emitter.Emitter
import nl.dionsegijn.konfetti.core.models.Size
import java.lang.ref.WeakReference
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList


object Utils {

    fun Double?.formatCurrencyRupiah(): String {
        val formatter = DecimalFormat("###,###,###.##")
        val formatRp = DecimalFormatSymbols()
        formatRp.groupingSeparator = '.'
        formatRp.decimalSeparator = ','
        formatter.decimalFormatSymbols = formatRp
        return "Rp. " + formatter.format(this)
    }

    fun LocalDate?.format1(): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return this?.format(formatter).toString()
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

    class Presets {
        companion object {
            fun festive(): List<Party> {
                val party = Party(
                    speed = 30f,
                    maxSpeed = 50f,
                    damping = 0.9f,
                    angle = Angle.TOP,
                    spread = 45,
                    size = listOf(Size.SMALL, Size.LARGE),
                    timeToLive = 3000L,
                    rotation = Rotation(),
                    colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
                    emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(30),
                    position = Position.Relative(0.5, 1.0)
                )

                return listOf(
                    party,
                    party.copy(
                        speed = 55f,
                        maxSpeed = 65f,
                        spread = 10,
                        emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(10),
                    ),
                    party.copy(
                        speed = 50f,
                        maxSpeed = 60f,
                        spread = 120,
                        emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(40),
                    ),
                    party.copy(
                        speed = 65f,
                        maxSpeed = 80f,
                        spread = 10,
                        emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(10),
                    )
                )
            }

            fun explode(): List<Party> {
                return listOf(
                    Party(
                        speed = 0f,
                        maxSpeed = 30f,
                        damping = 0.9f,
                        spread = 360,
                        colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
                        emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(100),
                        position = Position.Relative(0.5, 0.3)
                    )
                )
            }

            fun parade(): List<Party> {
                val party = Party(
                    speed = 10f,
                    maxSpeed = 30f,
                    damping = 0.9f,
                    angle = Angle.RIGHT - 45,
                    spread = Spread.SMALL,
                    colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
                    emitter = Emitter(duration = 5, TimeUnit.SECONDS).perSecond(30),
                    position = Position.Relative(0.0, 0.5)
                )

                return listOf(
                    party,
                    party.copy(
                        angle = party.angle - 90, // flip angle from right to left
                        position = Position.Relative(1.0, 0.5)
                    ),
                )
            }

            fun rain(): List<Party> {
                return listOf(
                    Party(
                        speed = 0f,
                        maxSpeed = 10f,
                        damping = 0.9f,
                        angle = Angle.BOTTOM,
                        spread = Spread.ROUND,
                        colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
                        emitter = Emitter(duration = 20, TimeUnit.SECONDS).perSecond(100),
                        position = Position.Relative(0.0, 0.0).between(Position.Relative(1.0, 0.0))
                    )
                )
            }
        }
    }

    class WishlistDecoration(var context:Context): RecyclerView.ItemDecoration(){
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            super.getItemOffsets(outRect, view, parent, state)
            super.getItemOffsets(outRect, view, parent, state)
            val itemPosition = parent.getChildAdapterPosition(view)

            if (itemPosition == 1) {
                outRect.top = context.resources.getDimensionPixelSize(com.daffa.core.R.dimen._20sdp)
            }
        }
    }

    fun getMonthList():ArrayList<String> {
        val month = LocalDate.now().monthValue
        val monthInt = listOf(1,2,3,4,5,6,7,8,9,10,11,12)
        val filter = monthInt.filter{it >= month }
        println("onresponse filter $filter")
        val monthListName = arrayListOf<String>()

        val monthName = mapOf(
            1 to "Januari",
            2 to "Februari",
            3 to "Maret",
            4 to "April",
            5 to "Mei",
            6 to "Juni",
            7 to "Juli",
            8 to "Agustus",
            9 to "Septermber",
            10 to "Oktober",
            11 to "November",
            12 to "Desember"
        )

        for (name in filter){
            monthListName.add(monthName[name].toString())
        }
        println("onresponse monthListName $monthListName")
        return monthListName
    }

}