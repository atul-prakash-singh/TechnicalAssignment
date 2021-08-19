package atulps.com.technicalassignment.di

import android.content.Context
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * [RetrofitClientInstance]
 * @brief This class provides Retrofit Client Instance to koin remoteModule
 * @author atul.ps
 * @date 03/27/2019
 */
object RetrofitClientInstance {

    private const val BASE_URL = "https://api.nytimes.com/svc/"
    private const val CACHE_SIZE = 10 * 1024 * 1024

    /**
     * [getRetrofitInstance]
     * @brief This method provides Retrofit Client Instance to koin remoteModule. It also maintains cache.
     * @param [context] Context
     * @return Retrofit
     * @author atul.ps
     * @date 03/27/2019
     */
    fun getRetrofitInstance(context: Context): Retrofit {
        val cache = Cache(context.cacheDir, CACHE_SIZE.toLong())

        val okHttpClient = OkHttpClient.Builder().cache(cache).build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}
