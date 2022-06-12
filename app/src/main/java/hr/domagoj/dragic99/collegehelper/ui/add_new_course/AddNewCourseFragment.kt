package hr.domagoj.dragic99.collegehelper.ui.add_new_course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.core.view.size
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
        buttonState(binding.btnAddCourse)
        binding.btnAddCourse.setOnClickListener{ saveCourse()}
    }

    private fun buttonState(btnAddCourse: Button) {
        binding.tilCourseNameInput.addOnEditTextAttachedListener {
            if (it.size < 2) buttonDisable(btnAddCourse)
            else buttonEnable(btnAddCourse)
        }
        binding.tilCourseLecturerInput.addOnEditTextAttachedListener {
            if (it.size < 2) buttonDisable(btnAddCourse)
            else buttonEnable(btnAddCourse)
        }
        binding.tilCourseNumOfAbsenceInput.addOnEditTextAttachedListener {
            if (it.size < 2) buttonDisable(btnAddCourse)
            else buttonEnable(btnAddCourse)
        }

    }

    private fun buttonEnable(btnAddCourse: Button){
        btnAddCourse.isEnabled = true
        btnAddCourse.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.grey))
        btnAddCourse.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))

    }

    private fun buttonDisable(btnAddCourse: Button){
        btnAddCourse.isEnabled = false
        btnAddCourse.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.button_disable))
        btnAddCourse.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
    }

    private fun saveCourse() {
        val courseName = binding.etCourseNameInput.text.toString()
        val courseLecturer = binding.etCourseLecturerInput.text.toString()
        val courseMaxNumOfAbsence = binding.etCourseNumOfAbsenceInput.text.toString()
        val courseAdditionalNotes = binding.etCourseAdditionalNotesInput.text.toString()

        val course = Course(0,courseName, courseLecturer, courseMaxNumOfAbsence, courseAdditionalNotes, 0)
        addNewCourseViewModel.insertCourse(course)

        val action = AddNewCourseFragmentDirections.actionAddNewCourseFragmentToCourseOverviewFragment()
        findNavController().navigate(action)
    }

}