package atulps.com.technicalassignment.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import atulps.com.technicalassignment.database.RoomArticleEntity
import atulps.com.technicalassignment.repository.ArticleRepository

/**
 * [ArticleMasterViewModel]
 * @brief ViewModel to supply data to [MainActivity]
 * @author atul.ps
 * @date 03/27/2019
 */
open class ArticleMasterViewModel(private val repository: ArticleRepository) : BaseViewModel() {

    var liveData: LiveData<PagedList<RoomArticleEntity>>? = null
    val progressBarVisibility = ObservableBoolean(true)

    /**
     * [fetchMostPopularArticles]
     * @brief Function to provide LiveData for Most Popular Articles
     * @return LiveData<PagedList<RoomArticleEntity>>
     * @author atul.ps
     * @date 03/27/2019
     */
    suspend fun fetchMostPopularArticles(): LiveData<PagedList<RoomArticleEntity>> =
        LivePagedListBuilder(
            repository.getMostPopularArticles(),
            PagedList.Config.Builder()
                .setPageSize(PAGE_SIZE)
                .setInitialLoadSizeHint(PAGE_SIZE)
                .setEnablePlaceholders(true)
                .build()
        ).build()

    companion object {
        const val PAGE_SIZE = 20
    }
}
