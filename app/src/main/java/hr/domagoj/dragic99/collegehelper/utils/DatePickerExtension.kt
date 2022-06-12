package hr.domagoj.dragic99.collegehelper.utils

import android.widget.DatePicker
import java.util.*

fun DatePicker.getDate(): Date {
    val calendar = Calendar.getInstance()
    calendar.set(year, month, dayOfMonth)
    return calendar.time
}