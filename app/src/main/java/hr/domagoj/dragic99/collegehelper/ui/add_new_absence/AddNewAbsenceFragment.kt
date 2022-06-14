package hr.domagoj.dragic99.collegehelper.ui.add_new_absence

import android.media.SoundPool
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
    private lateinit var mSoundPool: SoundPool
    private var mLoaded: Boolean = false
    var mSoundMap: HashMap<Int, Int> = HashMap()

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
            if (it < 1) {
                addNewAbsenceViewModel.returnNumOfAbsencesToOne()
            }
            binding.tvNumOfAbsences.text = it.toString()
        }
        binding.fabAddNumOfAbsences.setOnClickListener { addNewAbsenceViewModel.addNumOfAbsences() }
        binding.fabSubtractNumOfAbsences.setOnClickListener { addNewAbsenceViewModel.subtractNumOfAbsences() }
        binding.btnAddAbsence.setOnClickListener { saveAbsence(args.id) }
        loadSound()
    }

    private fun loadSound() {
        this.mSoundPool = SoundPool.Builder().setMaxStreams(10).build()
        this.mSoundPool.setOnLoadCompleteListener { _, _, _ -> mLoaded = true }
        this.mSoundMap[R.raw.awh_disappointing] =
            this.mSoundPool.load(requireContext(), R.raw.awh_disappointing, 1)
    }

    private fun saveAbsence(id: Int) {
        val courseName = args.courseName
        val absenceDate = binding.dpAbsenceDateInput.getDate()
        val numOfAbsences = addNewAbsenceViewModel.numOfAbsences.value

        for (i in 1..numOfAbsences!!) {
            val absence = Absence(0, courseName, absenceDate)
            addNewAbsenceViewModel.insertAbsence(absence)
        }

        playSound(R.raw.awh_disappointing)

        val action =
            AddNewAbsenceFragmentDirections.actionAddNewAbsenceFragmentToCourseDetailsFragment(id)
        findNavController().navigate(action)
    }

    private fun playSound(selectedSound: Int) {
        val soundID = this.mSoundMap[selectedSound] ?: 0
        this.mSoundPool.play(soundID, 1f, 1f, 1, 0, 1f)
    }
}

