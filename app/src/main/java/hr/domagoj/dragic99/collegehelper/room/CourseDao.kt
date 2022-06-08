package hr.domagoj.dragic99.collegehelper.room

import androidx.lifecycle.LiveData
import androidx.room.*
import hr.domagoj.dragic99.collegehelper.model.Course
import java.util.concurrent.Flow

@Dao
interface CourseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCourse(course: Course)

    @Query("SELECT * FROM course_table")
    fun readAllData() : LiveData<List<Course>>

    @Query("SELECT * FROM course_table WHERE id=:id")
    fun getCourseById(id: Int): Course?

    @Delete
    fun delete(course: Course)

}