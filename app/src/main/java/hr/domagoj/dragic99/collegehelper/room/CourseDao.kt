package hr.domagoj.dragic99.collegehelper.room

import androidx.lifecycle.LiveData
import androidx.room.*
import hr.domagoj.dragic99.collegehelper.model.Absence
import hr.domagoj.dragic99.collegehelper.model.Course
import java.util.concurrent.Flow

@Dao
interface CourseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCourse(course: Course)

    @Query("SELECT * FROM course_table")
    fun readAllData(): LiveData<List<Course>>

    @Query("SELECT * FROM course_table WHERE id=:id")
    fun getCourseById(id: Int): Course?

    @Delete
    fun deleteCourse(course: Course)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAbsence(absence: Absence)

    @Query("SELECT * FROM absence_table WHERE courseName=:courseName")
    fun readAllAbsencesByCourse(courseName: String): LiveData<List<Absence>>

    @Delete
    fun deleteAbsence(absence: Absence)

    @Query("DELETE FROM absence_table WHERE courseName=:courseName")
    fun deleteAllAbsenceFromCourse(courseName: String)

    @Query("UPDATE course_table SET courseCurrentNumOfAbsence=:value WHERE courseName=:courseName")
    fun updateCurrentNumberOfAbsences(value: Int, courseName: String)

}