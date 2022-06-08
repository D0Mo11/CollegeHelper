package hr.domagoj.dragic99.collegehelper.ui.course_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import hr.domagoj.dragic99.collegehelper.R
import hr.domagoj.dragic99.collegehelper.databinding.FragmentCourseDetailsBinding
import hr.domagoj.dragic99.collegehelper.model.Course
import org.koin.androidx.viewmodel.ext.android.viewModel

class CourseDetailsFragment : Fragment() {

    private lateinit var binding: FragmentCourseDetailsBinding
    private val args : CourseDetailsFragmentArgs by navArgs()
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
        displayCourseInfo(course)
        binding.btnAddAbsence.setOnClickListener { addAbsence(args.id) }

    }

    private fun addAbsence(id: Int) {
        val action = CourseDetailsFragmentDirections.actionCourseDetailsFragmentToAddNewAbsenceFragment(id)
        findNavController().navigate(action)
    }

    private fun displayCourseInfo(course: Course?) {
        course?.let {
            binding.apply {
                tvCourseName.text = course.courseName
                tvLecturer.text = course.courseLecturer
                tvAdditionalNotes.text = course.courseNotes
                return
            }
        }
        binding.tvCourseName.text = getString(R.string.label_no_course)
    }
}