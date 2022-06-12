package hr.domagoj.dragic99.collegehelper.ui.course_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import hr.domagoj.dragic99.collegehelper.model.Absence
import hr.domagoj.dragic99.collegehelper.model.Course
import hr.domagoj.dragic99.collegehelper.repositories.CourseRepository
import kotlin.math.abs

class CourseDetailsViewModel(private val courseRepository : CourseRepository): ViewModel(){

    fun readAllAbsencesByCourse(courseName: String): LiveData<List<Absence>> {
        return courseRepository.readAllAbsencesByCourse(courseName)
    }

    fun getCourseById(id: Int): Course? {
        var course: Course? = null
        id.let { course = courseRepository.getCourseById(id) }
        return course
    }

    fun deleteAbsence(absence: Absence){
        courseRepository.deleteAbsence(absence)
    }

    fun updateCurrentNumberOfAbsences(value: Int, courseName: String){
        return courseRepository.updateCurrentNumberOfAbsences(value, courseName)
    }

}