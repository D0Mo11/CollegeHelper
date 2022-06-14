package hr.domagoj.dragic99.collegehelper.repositories

import androidx.lifecycle.LiveData
import hr.domagoj.dragic99.collegehelper.model.Absence
import hr.domagoj.dragic99.collegehelper.model.Course
import hr.domagoj.dragic99.collegehelper.room.CourseDao

class CourseRepository(private val courseDao: CourseDao) {

    suspend fun insertCourse(course: Course) {
        courseDao.insertCourse(course)
    }

    fun readAllData(): LiveData<List<Course>> {
        return courseDao.readAllData()
    }

    fun getCourseById(id: Int): Course? {
        return courseDao.getCourseById(id)
    }

    fun deleteCourse(course: Course) {
        return courseDao.deleteCourse(course)
    }

    suspend fun insertAbsence(absence: Absence) {
        courseDao.insertAbsence(absence)
    }

    fun readAllAbsencesByCourse(courseName: String): LiveData<List<Absence>> {
        return courseDao.readAllAbsencesByCourse(courseName)
    }

    fun deleteAbsence(absence: Absence) {
        return courseDao.deleteAbsence(absence)
    }

    fun deleteAllAbsenceFromCourse(courseName: String) {
        return courseDao.deleteAllAbsenceFromCourse(courseName)
    }

    fun updateCurrentNumberOfAbsences(value: Int, courseName: String) {
        return courseDao.updateCurrentNumberOfAbsences(value, courseName)
    }

}