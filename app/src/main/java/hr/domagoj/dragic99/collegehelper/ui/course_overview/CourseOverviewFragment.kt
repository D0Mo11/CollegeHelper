package hr.domagoj.dragic99.collegehelper.ui.course_overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import hr.domagoj.dragic99.collegehelper.databinding.FragmentCourseOverviewBinding

class CourseOverviewFragment : Fragment() {

    lateinit var binding : FragmentCourseOverviewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCourseOverviewBinding.inflate(layoutInflater, container, false)
        binding.btnAddCourse.setOnClickListener{
        val action =CourseOverviewFragmentDirections.actionCourseOverviewFragmentToAddNewCourseFragment()
        findNavController().navigate(action)
        }
        return binding.root
    }
}