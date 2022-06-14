package hr.domagoj.dragic99.collegehelper.ui.course_overview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import hr.domagoj.dragic99.collegehelper.databinding.ItemCourseBinding
import hr.domagoj.dragic99.collegehelper.model.Course


class CourseOverviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(course: Course) {
        val binding = ItemCourseBinding.bind(itemView)
        binding.tvName.text = course.courseName
        binding.tvCurrentNumOfAbsence.text = course.courseCurrentNumOfAbsence.toString()
        binding.tvNumOfAbsence.text = course.courseMaxAbsence
    }
}