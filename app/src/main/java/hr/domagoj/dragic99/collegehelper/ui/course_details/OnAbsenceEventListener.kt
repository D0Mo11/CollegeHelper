package hr.domagoj.dragic99.collegehelper.ui.course_details

import hr.domagoj.dragic99.collegehelper.model.Absence

interface OnAbsenceEventListener {
    fun onAbsenceLongPress(absence: Absence?): Boolean
}