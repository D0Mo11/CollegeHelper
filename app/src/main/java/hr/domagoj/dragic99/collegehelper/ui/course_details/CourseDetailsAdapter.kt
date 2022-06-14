package hr.domagoj.dragic99.collegehelper.ui.course_details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.domagoj.dragic99.collegehelper.R
import hr.domagoj.dragic99.collegehelper.model.Absence

class CourseDetailsAdapter : RecyclerView.Adapter<CourseDetailsViewHolder>() {

    private val absences = mutableListOf<Absence>()
    var onAbsenceSelectedListener: OnAbsenceEventListener? = null

    fun setAbsences(absence: List<Absence>) {
        this.absences.clear()
        this.absences.addAll(absence)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseDetailsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_absence, parent, false)
        return CourseDetailsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseDetailsViewHolder, position: Int) {
        val absence = absences[position]
        holder.bind(absence)
        onAbsenceSelectedListener?.let { listener ->
            holder.itemView.setOnLongClickListener { listener.onAbsenceLongPress(absence) }
        }
    }

    override fun getItemCount(): Int = absences.count()
}