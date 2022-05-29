package hr.domagoj.dragic99.collegehelper.ui.add_new_course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import hr.domagoj.dragic99.collegehelper.databinding.FragmentAddNewCourseBinding

class AddNewCourseFragment : Fragment() {

    lateinit var binding: FragmentAddNewCourseBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddNewCourseBinding.inflate(layoutInflater, container, false)
        binding.btnAddCourse.setOnClickListener{
            val action = AddNewCourseFragmentDirections.actionAddNewCourseFragmentToCourseOverviewFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }
}