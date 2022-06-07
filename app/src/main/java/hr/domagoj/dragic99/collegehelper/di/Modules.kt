package hr.domagoj.dragic99.collegehelper.di

import androidx.room.Room
import hr.domagoj.dragic99.collegehelper.ui.add_new_course.AddNewCourseViewModel
import hr.domagoj.dragic99.collegehelper.repositories.CourseRepository
import hr.domagoj.dragic99.collegehelper.room.CourseDatabase
import hr.domagoj.dragic99.collegehelper.ui.course_overview.CourseOverviewViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val roomModule = module {

    single {
        Room.databaseBuilder(
            androidApplication(),
            CourseDatabase::class.java,
            "course_database"
        ).build()
    }
    single { get<CourseDatabase>().courseDao() }
}

val viewModelModule = module {

    viewModel { AddNewCourseViewModel(get()) }
    viewModel { CourseOverviewViewModel(get()) }
}

val repositoryModule = module {

    single { CourseRepository(get()) }
}
