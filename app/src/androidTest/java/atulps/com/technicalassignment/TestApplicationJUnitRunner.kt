package atulps.com.technicalassignment

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

class TestApplicationJUnitRunner : AndroidJUnitRunner() {

    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        return super.newApplication(cl, TestApplication::class.java.name, context)
    }
}