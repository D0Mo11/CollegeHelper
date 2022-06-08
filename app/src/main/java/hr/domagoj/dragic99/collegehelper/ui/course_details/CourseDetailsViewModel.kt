package hr.domagoj.dragic99.collegehelper.ui.course_details

import androidx.lifecycle.ViewModel
import hr.domagoj.dragic99.collegehelper.model.Course
import hr.domagoj.dragic99.collegehelper.repositories.CourseRepository

class CourseDetailsViewModel(val courseRepository : CourseRepository): ViewModel(){

    fun getCourseById(id: Int): Course? {
        var course: Course? = null
        id.let { course = courseRepository.getCourseById(id) }
        return course
    }

}