package hr.domagoj.dragic99.collegehelper.ui.course_overview

import hr.domagoj.dragic99.collegehelper.model.Course

interface OnCourseEventListener {
    fun onCourseSelected(id: Int?)
    fun onCourseLongPress(course: Course?): Boolean
}