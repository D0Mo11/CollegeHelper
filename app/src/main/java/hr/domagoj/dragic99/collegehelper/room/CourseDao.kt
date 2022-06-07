package hr.domagoj.dragic99.collegehelper.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hr.domagoj.dragic99.collegehelper.model.Course
import java.util.concurrent.Flow

@Dao
interface CourseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCourse(course: Course)

    @Query("SELECT * FROM course_table")
    fun readAllData() : LiveData<List<Course>>

}