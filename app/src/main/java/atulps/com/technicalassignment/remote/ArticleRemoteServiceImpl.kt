package atulps.com.technicalassignment.remote

import android.content.Context
import atulps.com.technicalassignment.di.RetrofitClientInstance
import atulps.com.technicalassignment.model.Results
import retrofit2.Call

/**
 * [ArticleRemoteServiceImpl]
 * @brief Retrofit Service to fetch Most Popular Articles Data from NY TIMES
 * @author atul.ps
 * @date 03/27/2019
 */
class ArticleRemoteServiceImpl(
    private val context: Context
) : ArticleRemoteService {

    /**
     * [getMostPopularArticles]
     * @brief Function to fetch Most Popular Articles Data from remote source
     * @param [limit] Int
     * @param [apiKey] String
     * @return Call<Results>
     * @author atul.ps
     * @date 03/27/2019
     */
    override fun getMostPopularArticles(limit: Int, apiKey: String): Call<Results> =
        RetrofitClientInstance.getRetrofitInstance(context)
            .create(ArticleRemoteService::class.java)
            .getMostPopularArticles()
}
