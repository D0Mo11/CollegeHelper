package hr.domagoj.dragic99.collegehelper.ui.course_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import hr.domagoj.dragic99.collegehelper.R
import hr.domagoj.dragic99.collegehelper.databinding.FragmentCourseDetailsBinding
import hr.domagoj.dragic99.collegehelper.model.Absence
import hr.domagoj.dragic99.collegehelper.model.Course
import org.koin.androidx.viewmodel.ext.android.viewModel

class CourseDetailsFragment : Fragment(), OnAbsenceEventListener {

    private lateinit var binding: FragmentCourseDetailsBinding
    private lateinit var adapter: CourseDetailsAdapter
    private val args: CourseDetailsFragmentArgs by navArgs()
    private val courseDetailsViewModel: CourseDetailsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCourseDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val course = courseDetailsViewModel.getCourseById(args.id)
        setupRecycler()
        displayCourseInfo(course)
        val courseName = binding.tvCourseName.text.toString()
        val absences = courseDetailsViewModel.readAllAbsencesByCourse(courseName)
        absences.observe(viewLifecycleOwner) {
            if (it != null && it.isNotEmpty()) {
                adapter.setAbsences(it)
                val updatedNumOfAbsences = adapter.itemCount
                if(updatedNumOfAbsences == 0) binding.tvCurrentNumOfAbsence.text = "0"
                else binding.tvCurrentNumOfAbsence.text = updatedNumOfAbsences.toString()
                courseDetailsViewModel.updateCurrentNumberOfAbsences(
                    updatedNumOfAbsences,
                    courseName
                )
            }
        }
        binding.btnAddAbsence.setOnClickListener { addAbsence(args.id, courseName) }

    }

    private fun setupRecycler() {
        binding.rvAbsenceList.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        adapter = CourseDetailsAdapter()
        adapter.onAbsenceSelectedListener = this
        binding.rvAbsenceList.adapter = adapter
    }

    private fun addAbsence(id: Int, courseName: String) {
        val action =
            CourseDetailsFragmentDirections.actionCourseDetailsFragmentToAddNewAbsenceFragment(
                id,
                courseName
            )
        findNavController().navigate(action)
    }

    private fun displayCourseInfo(course: Course?) {
        course?.let {
            binding.apply {
                tvCourseName.text = course.courseName
                tvLecturer.text = course.courseLecturer
                tvAdditionalNotes.text = course.courseNotes
                tvMaxNumOfAbsence.text = course.courseMaxAbsence
                return
            }
        }
        binding.tvCourseName.text = getString(R.string.label_no_course)
    }

    override fun onAbsenceLongPress(absence: Absence?): Boolean {
        absence?.let { it ->
            courseDetailsViewModel.deleteAbsence(it)
        }
        return true
    }

}