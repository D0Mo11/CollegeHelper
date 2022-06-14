package hr.domagoj.dragic99.collegehelper.ui.course_details

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import hr.domagoj.dragic99.collegehelper.databinding.ItemAbsenceBinding
import hr.domagoj.dragic99.collegehelper.model.Absence
import java.text.SimpleDateFormat

class CourseDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    @SuppressLint("SimpleDateFormat")
    fun bind(absence: Absence) {
        val binding = ItemAbsenceBinding.bind(itemView)
        binding.tvAbsenceDate.text = SimpleDateFormat("dd.MM.yyyy").format(absence.absenceDate)
    }
}