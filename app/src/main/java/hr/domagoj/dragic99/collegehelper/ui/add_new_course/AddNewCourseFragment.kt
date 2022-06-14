package hr.domagoj.dragic99.collegehelper.ui.add_new_course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import hr.domagoj.dragic99.collegehelper.R
import hr.domagoj.dragic99.collegehelper.databinding.FragmentAddNewCourseBinding
import hr.domagoj.dragic99.collegehelper.model.Course
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddNewCourseFragment : Fragment() {

    private lateinit var binding: FragmentAddNewCourseBinding
    private val addNewCourseViewModel: AddNewCourseViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddNewCourseBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAddCourse.setOnClickListener { checkInput() }
    }

    private fun checkInput() {
        val courseName = binding.etCourseNameInput.text
        val courseLecturer = binding.etCourseLecturerInput.text
        val courseNumOfAbsence = binding.etCourseNumOfAbsenceInput.text

        if (courseName.isNotEmpty() && courseLecturer.isNotEmpty() && courseNumOfAbsence.isNotEmpty()) {
            saveCourse()
        } else makeToast()
    }

    private fun makeToast() {
        Toast.makeText(requireContext(), R.string.required_text, Toast.LENGTH_SHORT).show()
    }

    private fun saveCourse() {
        val courseName = binding.etCourseNameInput.text.toString()
        val courseLecturer = binding.etCourseLecturerInput.text.toString()
        val courseMaxNumOfAbsence = binding.etCourseNumOfAbsenceInput.text.toString()
        val courseAdditionalNotes = binding.etCourseAdditionalNotesInput.text.toString()

        val course =
            Course(0, courseName, courseLecturer, courseMaxNumOfAbsence, courseAdditionalNotes, 0)
        addNewCourseViewModel.insertCourse(course)

        val action =
            AddNewCourseFragmentDirections.actionAddNewCourseFragmentToCourseOverviewFragment()
        findNavController().navigate(action)
    }

}