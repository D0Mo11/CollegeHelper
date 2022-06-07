package hr.domagoj.dragic99.collegehelper.ui.add_new_course

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hr.domagoj.dragic99.collegehelper.model.Course
import hr.domagoj.dragic99.collegehelper.repositories.CourseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewCourseViewModel(private val courseRepository: CourseRepository) : ViewModel() {

    fun insertCourse(course: Course) {
        viewModelScope.launch(Dispatchers.IO) {
            courseRepository.insertCourse(course)
        }
    }
}