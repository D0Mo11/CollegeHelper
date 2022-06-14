package hr.domagoj.dragic99.collegehelper.ui.add_new_absence

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hr.domagoj.dragic99.collegehelper.model.Absence
import hr.domagoj.dragic99.collegehelper.repositories.CourseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewAbsenceViewModel(private val courseRepository: CourseRepository) : ViewModel() {

    private val _numOfAbsences: MutableLiveData<Int> = MutableLiveData<Int>(1)
    val numOfAbsences: LiveData<Int> = _numOfAbsences

    fun insertAbsence(absence: Absence) {
        viewModelScope.launch(Dispatchers.IO) {
            courseRepository.insertAbsence(absence)
        }
    }

    fun addNumOfAbsences() {
        _numOfAbsences.value?.let { _numOfAbsences.postValue(it + 1) }
    }

    fun subtractNumOfAbsences() {
        _numOfAbsences.value?.let { _numOfAbsences.postValue(it - 1) }
    }

    fun returnNumOfAbsencesToOne() {
        _numOfAbsences.value?.let { _numOfAbsences.postValue(1) }
    }
}