package atulps.com.technicalassignment

import android.app.Application
import org.koin.android.ext.android.startKoin

class TestApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this@TestApplication, emptyList())
    }
}
