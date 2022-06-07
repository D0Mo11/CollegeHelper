package hr.domagoj.dragic99.collegehelper.ui.course_overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import hr.domagoj.dragic99.collegehelper.databinding.FragmentCourseOverviewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CourseOverviewFragment : Fragment(), OnCourseEventListener {

    private lateinit var binding : FragmentCourseOverviewBinding
    private lateinit var adapter: CourseOverviewAdapter
    private val courseOverviewViewModel: CourseOverviewViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCourseOverviewBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAddCourse.setOnClickListener{ addCourse()}
        setupRecycler()
        courseOverviewViewModel.courses.observe(viewLifecycleOwner){
            if(it!=null && it.isNotEmpty()){
                adapter.setCourses(it)
            }
        }
    }

    private fun setupRecycler() {
        binding.rvCoursesList.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        adapter= CourseOverviewAdapter()
        adapter.onCourseSelectedListener = this
        binding.rvCoursesList.adapter = adapter
    }

    private fun addCourse() {
        val action = CourseOverviewFragmentDirections.actionCourseOverviewFragmentToAddNewCourseFragment()
        findNavController().navigate(action)
    }

    override fun onCourseSelected(id: Int?) {
        val action = CourseOverviewFragmentDirections.actionCourseOverviewFragmentToCourseDetailsFragment(id?: -1)
        findNavController().navigate(action)
    }
}