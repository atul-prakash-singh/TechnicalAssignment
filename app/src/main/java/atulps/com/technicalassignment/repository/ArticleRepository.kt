package atulps.com.technicalassignment.repository

import androidx.paging.DataSource
import atulps.com.technicalassignment.database.RoomArticleDao
import atulps.com.technicalassignment.database.RoomArticleEntity
import atulps.com.technicalassignment.model.Article
import atulps.com.technicalassignment.model.Results
import atulps.com.technicalassignment.remote.ArticleRemoteService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

/**
 * [ArticleRepository]
 * @brief Repository class to fetch data from remote api & room persistence storage
 * @author atul.ps
 * @date 03/27/2019
 */
class ArticleRepository(private val articleDao: RoomArticleDao) {

    /**
     * [getMostPopularArticles]
     * @return DataSource.Factory<Int, RoomArticleEntity>
     * @author atul.ps
     * @date 03/27/2019
     */
    suspend fun getMostPopularArticles(): DataSource.Factory<Int, RoomArticleEntity> =
        withContext(CoroutineScope(Dispatchers.Default).coroutineContext) {
            articleDao.getArticles()
        }

    /**
     * [insert]
     * @brief Function to insert article into DB
     * @param [item] RoomArticleEntity
     * @author atul.ps
     * @date 03/27/2019
     */
    private suspend fun insert(item: RoomArticleEntity) =
        withContext(CoroutineScope(Dispatchers.Default).coroutineContext) {
            articleDao.insertEntity(item)
        }

    /**
     * [isDatabaseEmpty]
     * @brief Function to check empty DB
     * @return Boolean
     * @author atul.ps
     * @date 03/27/2019
     */
    suspend fun isDatabaseEmpty() =
        withContext(CoroutineScope(Dispatchers.Default).coroutineContext) {
            articleDao.getArticleCount() <= 0
        }

    /**
     * [fetchAndSaveMostPopularArticles]
     * @brief function to fetch data from remote source and saves in Room Persistent Storage
     * @param [service] ArticleRemoteService
     * @author atul.ps
     * @date 03/27/2019
     */
    suspend fun fetchAndSaveMostPopularArticles(service: ArticleRemoteService) =
        withContext(CoroutineScope(Dispatchers.Default).coroutineContext) {

            if (isDatabaseEmpty()) {
                service.getMostPopularArticles().enqueue(object : Callback<Results> {
                    override fun onResponse(call: Call<Results>, response: Response<Results>) {
                        Timber.d("onResponse() ${response.body()?.articles?.size}")
                        CoroutineScope(Dispatchers.Main).launch {
                            insertArticlesToDatabase(response.body()?.articles ?: emptyList())
                        }
                    }

                    override fun onFailure(call: Call<Results>, t: Throwable) {
                        Timber.e("onFailure() ${t.localizedMessage}")
                    }
                })
            }
        }

    /**
     * [insertArticlesToDatabase]
     * @brief Function to insert fetched remote article into DB
     * @param [articles] List<Article>
     * @author atul.ps
     * @date 03/27/2019
     */
    suspend fun insertArticlesToDatabase(articles : List<Article>) {
        for (article in articles) {
            insert(RoomArticleEntity(
                id = article.id,
                url = article.url,
                title = article.title,
                byLine = article.byLine,
                detailAbstract = article.detailAbstract,
                publishedDate = article.publishedDate,
                imageThumbnail = article.media[0].metaData[0].url,
                imageLarge = article.media[0].metaData[2].url
            ))
        }
    }
}
