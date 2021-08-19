package atulps.com.technicalassignment.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * [BaseActivity]
 * @brief Abstract Base class to provide common data binding methods
 * @author atul.ps
 * @date 03/27/2019
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDataBinding()
    }

    /**
     * [initDataBinding]
     * @brief Function to initialize common data binding layout and viewModel
     * @author atul.ps
     * @date 03/27/2019
     */
    abstract fun initDataBinding()
}
