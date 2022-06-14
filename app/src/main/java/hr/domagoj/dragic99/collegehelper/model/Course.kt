package hr.domagoj.dragic99.collegehelper.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course_table")
data class Course(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val courseName: String,
    val courseLecturer: String,
    val courseMaxAbsence: String,
    val courseNotes: String,
    val courseCurrentNumOfAbsence: Int
)
