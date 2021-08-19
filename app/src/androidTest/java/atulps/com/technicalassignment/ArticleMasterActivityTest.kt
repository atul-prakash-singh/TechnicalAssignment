package atulps.com.technicalassignment

import android.content.Intent
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.rule.ActivityTestRule
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until.hasObject
import atulps.com.technicalassignment.database.RoomArticleDatabase
import atulps.com.technicalassignment.database.RoomArticleEntity
import atulps.com.technicalassignment.kakaoscreens.ArticleMasterScreen
import atulps.com.technicalassignment.repository.ArticleRepository
import atulps.com.technicalassignment.ui.ArticleMasterActivity
import atulps.com.technicalassignment.viewmodel.ArticleMasterViewModel
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import org.koin.standalone.StandAloneContext.loadKoinModules
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.StandAloneContext.stopKoin
import org.koin.test.KoinTest
import org.mockito.Mockito.mock

@RunWith(AndroidJUnit4::class)
class ArticleMasterActivityTest : KoinTest {

    @Rule
    @JvmField
    val rule = ActivityTestRule(ArticleMasterActivity::class.java, true, false)

    private val screen = ArticleMasterScreen()

    private lateinit var articleDataBase: RoomArticleDatabase

    @Test
    fun testA_UIElements() {
        screen {
            progressBar {
                isCompletelyDisplayed()
            }

            recyclerView {
                isCompletelyDisplayed()
                hasSize(0)
            }
        }
    }

    @Test
    fun testB_DataInflation() {
        mockArticle()

        UiDevice.getInstance(getInstrumentation()).wait(hasObject(By.text(TITLE).depth(0)), DELAY)

        screen {
            recyclerView {
                isCompletelyDisplayed()
                hasSize(1)
                childAt<ArticleMasterScreen.ArticleMasterItem>(0) {
                    icon {
                        isCompletelyDisplayed()
                        hasDrawable(R.drawable.circular_placeholder)
                    }
                    title {
                        isCompletelyDisplayed()
                        hasText(TITLE)
                        hasTextColor(R.color.colorGrey)
                    }
                    byLine {
                        isCompletelyDisplayed()
                        hasText(BYLINE)
                        hasTextColor(R.color.colorDarkGrey)
                    }
                    iconDate {
                        isCompletelyDisplayed()
                        hasDrawable(R.drawable.ic_date)
                    }
                    publishedDate {
                        isCompletelyDisplayed()
                        hasText(PUBLISHED_DATE)
                        hasTextColor(R.color.colorDarkGrey)
                    }
                    arrow {
                        isCompletelyDisplayed()
                        hasDrawable(R.drawable.ic_arrow)
                    }
                }
            }
            progressBar {
                isGone()
            }
        }
    }

    @Test
    fun testC_OnClickNavigation() {
        mockArticle()

        UiDevice.getInstance(getInstrumentation()).wait(hasObject(By.text(TITLE).depth(0)), DELAY)

        screen {
            recyclerView {
                isCompletelyDisplayed()
                hasSize(1)
                childAt<ArticleMasterScreen.ArticleMasterItem>(0){
                    arrow {
                        isCompletelyDisplayed()
                        click()
                    }
                }
            }
        }

        //Detail Abstract is getting displayed on ArticleDetailScreen
        UiDevice.getInstance(getInstrumentation()).wait(hasObject(By.text(DETAIL_ABSTRACT).depth(0)), DELAY)
    }

    @Before
    fun setup() {
        articleDataBase = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().targetContext,
            RoomArticleDatabase::class.java
        ).build()

        loadKoinModules(module {
            single { articleDataBase.articleDao() }
            single { ArticleRepository(get()) }
            viewModel { ArticleMasterViewModel(get()) }
        })

        rule.launchActivity(Intent())
    }

    @After
    fun cleanUp() {
        if (articleDataBase.isOpen)
            articleDataBase.close()

        stopKoin()
    }

    private fun mockArticle() {
        runBlocking {
            articleDataBase.articleDao().insertEntity(
                RoomArticleEntity(
                    id = 1,
                    title = TITLE,
                    url = URL,
                    byLine = BYLINE,
                    detailAbstract = DETAIL_ABSTRACT,
                    publishedDate = PUBLISHED_DATE,
                    imageThumbnail = IMAGE_THUMBNAIL,
                    imageLarge = IMAGE_LARGE
                )
            )
        }
    }

    companion object {
        private const val DELAY = 1000L
        private const val TITLE = "TITLE"
        private const val URL = "URL"
        private const val BYLINE = "BYLINE"
        private const val DETAIL_ABSTRACT = "DETAIL_ABSTRACT"
        private const val PUBLISHED_DATE = "PUBLISHED_DATE"
        private const val IMAGE_THUMBNAIL = "IMAGE_THUMBNAIL"
        private const val IMAGE_LARGE = "IMAGE_LARGE"
    }
}