package hr.domagoj.dragic99.collegehelper.ui.add_new_absence

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import hr.domagoj.dragic99.collegehelper.R
import hr.domagoj.dragic99.collegehelper.databinding.FragmentAddNewAbsenceBinding
import hr.domagoj.dragic99.collegehelper.model.Absence
import hr.domagoj.dragic99.collegehelper.utils.getDate
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddNewAbsenceFragment : Fragment() {

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
        addNewAbsenceViewModel.numOfAbsences.observe(viewLifecycleOwner) {
            if(it < 1 ){
                addNewAbsenceViewModel.returnNumOfAbsencesToOne()
            }
            binding.tvNumOfAbsences.text = it.toString()
        }
        binding.fabAddNumOfAbsences.setOnClickListener{ addNewAbsenceViewModel.addNumOfAbsences() }
        binding.fabSubtractNumOfAbsences.setOnClickListener{ addNewAbsenceViewModel.subtractNumOfAbsences() }
        binding.btnAddAbsence.setOnClickListener { saveAbsence(args.id) }
    }

    private fun saveAbsence(id: Int) {
        val courseName = args.courseName
        val absenceDate = binding.dpAbsenceDateInput.getDate()
        val numOfAbsences = addNewAbsenceViewModel.numOfAbsences.value

        for(i in 1..numOfAbsences!!){
            val absence = Absence(0,courseName, absenceDate)
            addNewAbsenceViewModel.insertAbsence(absence)
        }

        val action =
            AddNewAbsenceFragmentDirections.actionAddNewAbsenceFragmentToCourseDetailsFragment(id)
        findNavController().navigate(action)
    }
}

