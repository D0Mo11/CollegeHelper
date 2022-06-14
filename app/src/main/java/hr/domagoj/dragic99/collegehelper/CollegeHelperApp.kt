package hr.domagoj.dragic99.collegehelper

import android.app.Application
import hr.domagoj.dragic99.collegehelper.di.repositoryModule
import hr.domagoj.dragic99.collegehelper.di.roomModule
import hr.domagoj.dragic99.collegehelper.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class CollegeHelperApp : Application() {
    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidContext(this@CollegeHelperApp)
            modules(
                viewModelModule,
                roomModule,
                repositoryModule
            )
        }
    }
}