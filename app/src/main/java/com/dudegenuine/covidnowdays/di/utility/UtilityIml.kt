package com.dudegenuine.covidnowdays.di.utility

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.text.format.DateUtils
import androidx.appcompat.app.AppCompatActivity
import com.dudegenuine.covidnowdays.R
import com.dudegenuine.covidnowdays.base.BaseApplication
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow

/**
 * Covid Nowdays created by utifmd on 01/06/21.
 */
class UtilityIml(androidContext: Context): IUtility{
    override fun getStrPrettyIdr(item: Int): String {
        val suffix = arrayOf("", "rb", "jt", "tr", "kr", "P", "E") // val suffix = charArrayOf(' ', 'k', 'M', 'B', 'T', 'P', 'E')
        val numValue = item.toLong()
        val value = floor(log10(numValue.toDouble())).toInt()
        val base = value / 3

        return if (value >= 3 && base < suffix.size)
            DecimalFormat("#0").format(numValue / 10.0.pow((base * 3))) + suffix[base] /*DecimalFormat("#0.0").format(numValue / 10.0.pow((base * 3).toDouble())) + suffix[base]*/
        else
            DecimalFormat("#,##0").format(numValue)
    }

    override fun getStrPrettyTime(item: Long): String {
        val current = Date(item)
        SimpleDateFormat("yyyy MM dd HH:mm:ss", Locale.US).apply { format(current) }
        val timeAgo = DateUtils.getRelativeTimeSpanString(current.time , Calendar.getInstance().timeInMillis, DateUtils.MINUTE_IN_MILLIS)

        return timeAgo.toString()
    }

    override fun getStrNormalIdr(item: Int): String =
        DecimalFormat("#,###").format(item)

    override fun getStrTitleCase(item: String): String =
        item.lowercase().replaceFirstChar { it.titlecase(Locale.getDefault()) }

    override fun getWidgetAlertMessage(context: Context, title: String, message: String) {
        AlertDialog.Builder(context).apply {
            setTitle(title)
            setMessage(message)
            create()
            show()
        }
    }

    override fun getWidgetShareText(context: Context, title: String, text: String) {
        context.startActivity(
            Intent.createChooser(Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TITLE, title)
                putExtra(Intent.EXTRA_TEXT, text) // data = contentUri
                flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
            }, null)
        )
    }
}