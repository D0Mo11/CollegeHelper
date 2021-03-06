package hr.domagoj.dragic99.collegehelper.ui.course_overview


import androidx.lifecycle.ViewModel
import hr.domagoj.dragic99.collegehelper.model.Course
import hr.domagoj.dragic99.collegehelper.repositories.CourseRepository

class CourseOverviewViewModel(private val courseRepository: CourseRepository) : ViewModel() {

    val courses = courseRepository.readAllData()

    fun deleteCourse(course: Course) {
        courseRepository.deleteCourse(course)
    }

    fun deleteAllAbsenceFromCourse(courseName: String) {
        courseRepository.deleteAllAbsenceFromCourse(courseName)
    }

}