package hr.domagoj.dragic99.collegehelper.ui.add_new_course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import hr.domagoj.dragic99.collegehelper.databinding.FragmentAddNewCourseBinding
import hr.domagoj.dragic99.collegehelper.model.Course
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddNewCourseFragment : Fragment() {

    lateinit var binding: FragmentAddNewCourseBinding
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
        binding.btnAddCourse.setOnClickListener{ saveCourse()}
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