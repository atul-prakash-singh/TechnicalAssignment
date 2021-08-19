package atulps.com.technicalassignment.remote

import atulps.com.technicalassignment.model.Results
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * [ArticleRemoteService]
 * @brief Retrofit Service to fetch Most Popular Articles Data from NY TIMES
 * @author atul.ps
 * @date 03/27/2019
 */
interface ArticleRemoteService {

    /**
     * [getMostPopularArticles]
     * @brief Function to fetch Most Popular Articles Data from remote source
     * @param [limit] Int
     * @param [apiKey] String
     * @return Call<Results>
     * @author atul.ps
     * @date 03/27/2019
     */
    @GET("mostpopular/v2/viewed/{limit}.json")
    fun getMostPopularArticles(
        @Path("limit") limit: Int = DEFAULT_LIMIT,
        @Query("api-key") apiKey: String = API_KEY): Call<Results>

    companion object {
        private const val DEFAULT_LIMIT = 7
        private const val API_KEY = "VkSCQpf6gV1xApIqp8w2TsPNzrAA576t"
    }
}
