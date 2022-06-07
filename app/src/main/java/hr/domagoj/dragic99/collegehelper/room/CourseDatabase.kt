package hr.domagoj.dragic99.collegehelper.room

import androidx.room.Database
import androidx.room.RoomDatabase
import hr.domagoj.dragic99.collegehelper.model.Course

@Database(entities = [Course::class], version = 1, exportSchema = false)
abstract class CourseDatabase : RoomDatabase(){

    abstract fun courseDao(): CourseDao
}