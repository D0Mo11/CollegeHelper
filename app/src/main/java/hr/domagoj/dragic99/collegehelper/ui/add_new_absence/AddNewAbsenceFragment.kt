package hr.domagoj.dragic99.collegehelper.ui.add_new_absence

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import hr.domagoj.dragic99.collegehelper.databinding.FragmentAddNewAbsenceBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddNewAbsenceFragment: Fragment() {

    private lateinit var binding: FragmentAddNewAbsenceBinding
    private val args: AddNewAbsenceFragmentArgs by navArgs()
    private val addNewAbsenceViewModel: AddNewAbsenceViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddNewAbsenceBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAddAbsence.setOnClickListener { addAbsence(args.id) }
    }

    private fun addAbsence(id: Int) {
        val action = AddNewAbsenceFragmentDirections.actionAddNewAbsenceFragmentToCourseDetailsFragment(id)
        findNavController().navigate(action)
    }
}