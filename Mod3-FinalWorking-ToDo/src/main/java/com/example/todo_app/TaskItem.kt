package com.example.todo_app

import android.content.Context
import androidx.core.content.ContextCompat
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

class TaskItem(
    var name: String,
    var desc: String,
    var dueTime: LocalTime?,
    var completedDate: LocalDate?,
    var id: UUID = UUID.randomUUID()
)
{
    fun isCompleted() = completedDate != null
    fun imageResource(): Int = if(isCompleted()) R.drawable.checked_24 else R.drawable.unchecked_24
    fun imageColor(context: Context): Int = if(isCompleted()) blue(context) else black(context)

    private fun blue(context: Context) = ContextCompat.getColor(context, androidx.appcompat.R.color.material_blue_grey_800)
    private fun black(context: Context) = ContextCompat.getColor(context, R.color.black)
}