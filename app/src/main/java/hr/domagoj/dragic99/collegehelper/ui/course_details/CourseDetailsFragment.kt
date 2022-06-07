package hr.domagoj.dragic99.collegehelper.ui.course_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import hr.domagoj.dragic99.collegehelper.databinding.FragmentCourseDetailsBinding

class CourseDetailsFragment : Fragment() {

    private lateinit var binding: FragmentCourseDetailsBinding
    private val args : CourseDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCourseDetailsBinding.inflate(layoutInflater, container, false)
        binding.tvCourses.text = args.id.toString()
        return binding.root
    }
}