package hr.domagoj.dragic99.collegehelper.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "absence_table")
data class Absence(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val courseName: String,
    val absenceDate: Date
)