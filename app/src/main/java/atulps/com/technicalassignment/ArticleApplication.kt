package atulps.com.technicalassignment

import android.app.Application
import atulps.com.technicalassignment.di.appModule
import atulps.com.technicalassignment.remote.ArticleRemoteService
import atulps.com.technicalassignment.repository.ArticleRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get
import org.koin.android.ext.android.startKoin
import timber.log.Timber

/**
 * [ArticleApplication]
 * @brief Application class to Initialize Koin & Timber.
 * Also it fetches data from remote source and saves in Room Persistent Storage
 * @author atul.ps
 * @date 03/27/2019
 */
class ArticleApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initializeKoin()
        plantTimber()

        fetchAndSaveMostPopularArticles()
    }

    /**
     * [initializeKoin]
     * @brief Function to Initialize Koin.
     * @author atul.ps
     * @date 03/27/2019
     */
    private fun initializeKoin() {
        startKoin(this@ArticleApplication, appModule)
    }

    /**
     * [plantTimber]
     * @brief Function to Initialize Timber Logging.
     * @author atul.ps
     * @date 03/27/2019
     */
    private fun plantTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    /**
     * [fetchAndSaveMostPopularArticles]
     * @brief function to fetch data from remote source and saves in Room Persistent Storage
     * @author atul.ps
     * @date 03/27/2019
     */
    private fun fetchAndSaveMostPopularArticles() {
        CoroutineScope(Dispatchers.Main).launch {
            val repository: ArticleRepository = get()
            val remoteService: ArticleRemoteService = get()
            repository.fetchAndSaveMostPopularArticles(remoteService)
        }
    }
}
