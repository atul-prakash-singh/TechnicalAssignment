package atulps.com.technicalassignment.repository

import android.app.Application
import android.content.Context
import androidx.paging.DataSource
import atulps.com.technicalassignment.database.RoomArticleDao
import atulps.com.technicalassignment.database.RoomArticleEntity
import atulps.com.technicalassignment.model.Article
import atulps.com.technicalassignment.model.Image
import atulps.com.technicalassignment.model.Media
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.koin.test.AutoCloseKoinTest

class ArticleRepositoryTest : AutoCloseKoinTest() {

    private lateinit var repository: ArticleRepository

    private val application: Application = mock()
    private val context: Context = mock()

    @Test
    fun testInsertArticlesToDataBase() {

        runBlocking {
            Assert.assertTrue(repository.isDatabaseEmpty())

            val list = arrayListOf(
                Article(
                    id = 1,
                    url = "",
                    byLine = "",
                    title = "",
                    detailAbstract = "",
                    publishedDate = "",
                    media = arrayListOf(
                        Media(
                            copyRight = "",
                            metaData = arrayListOf(
                                Image(url = "", format = ""),
                                Image(url = "", format = ""),
                                Image(url = "", format = "")
                            )
                        )
                    )
                )
            )
            repository.insertArticlesToDatabase(list)

            Assert.assertTrue(repository.isDatabaseEmpty())
        }
    }

    @Test
    fun testFetchAndSaveMostPopularArticles() {

    }

    @Before
    fun prepareViewModel() {

        val articleDao: RoomArticleDao = mock()

        whenever(application.applicationContext).thenReturn(context)

        val factory: DataSource.Factory<Int, RoomArticleEntity> = mock()
        whenever(articleDao.getArticles()).thenReturn(factory)

        repository = ArticleRepository(articleDao)
    }
}
