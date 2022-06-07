package hr.domagoj.dragic99.collegehelper.ui.course_overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.domagoj.dragic99.collegehelper.R
import hr.domagoj.dragic99.collegehelper.model.Course

class CourseOverviewAdapter: RecyclerView.Adapter<CourseOverviewViewHolder>() {

    private val courses = mutableListOf<Course>()
    var onCourseSelectedListener: OnCourseEventListener? = null

    fun setCourses(courses : List<Course>){
        this.courses.clear()
        this.courses.addAll(courses)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseOverviewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        return CourseOverviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseOverviewViewHolder, position: Int) {
        val course = courses[position]
        holder.bind(course)
        onCourseSelectedListener?.let { listener ->
            holder.itemView.setOnClickListener{ listener.onCourseSelected(course.id)}
        }
    }

    override fun getItemCount(): Int = courses.count()
}