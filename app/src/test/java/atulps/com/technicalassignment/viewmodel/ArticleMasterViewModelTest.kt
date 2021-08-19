package atulps.com.technicalassignment.viewmodel

import androidx.paging.DataSource
import atulps.com.technicalassignment.database.RoomArticleDao
import atulps.com.technicalassignment.database.RoomArticleEntity
import atulps.com.technicalassignment.repository.ArticleRepository
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * [ArticleMasterViewModelTest]
 * @brief JUnit test class for [ArticleMasterViewModel]
 * @author atul.ps
 * @date 03/27/2019
 */
class ArticleMasterViewModelTest {

    private lateinit var viewModel: ArticleMasterViewModel

    @Test
    fun testFetchMostPopularArticles() {
        runBlocking {
            viewModel.liveData = viewModel.fetchMostPopularArticles()
            Assert.assertNotNull(viewModel.liveData)
        }
    }

    @Test
    fun testInitializationViewModel() {
        val liveData = viewModel.liveData
        val progressBarVisibility = viewModel.progressBarVisibility.get()

        Assert.assertNull(liveData)
        Assert.assertTrue(progressBarVisibility)
    }

    @Before
    fun prepareViewModel() {
        val articleDao: RoomArticleDao = mock()

        val factory: DataSource.Factory<Int, RoomArticleEntity> = mock()
        whenever(articleDao.getArticles()).thenReturn(factory)

        viewModel = ArticleMasterViewModel(ArticleRepository(articleDao))
    }
}