package hr.domagoj.dragic99.collegehelper.repositories

import androidx.lifecycle.LiveData
import hr.domagoj.dragic99.collegehelper.model.Course
import hr.domagoj.dragic99.collegehelper.room.CourseDao

class CourseRepository(private val courseDao: CourseDao) {

    suspend fun insertCourse(course: Course){
        courseDao.insertCourse(course)
    }

    fun readAllData(): LiveData<List<Course>> {
        return courseDao.readAllData()
    }


}