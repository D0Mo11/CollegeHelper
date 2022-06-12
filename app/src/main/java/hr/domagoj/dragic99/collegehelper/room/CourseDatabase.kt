package hr.domagoj.dragic99.collegehelper.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import hr.domagoj.dragic99.collegehelper.model.Absence
import hr.domagoj.dragic99.collegehelper.model.Course

@Database(entities = [Course::class, Absence::class], version = 1, exportSchema = false)
@TypeConverters(hr.domagoj.dragic99.collegehelper.room.TypeConverters::class)
abstract class CourseDatabase : RoomDatabase(){

    abstract fun courseDao(): CourseDao
}